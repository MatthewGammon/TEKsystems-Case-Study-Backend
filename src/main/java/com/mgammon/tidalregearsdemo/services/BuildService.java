package com.mgammon.tidalregearsdemo.services;

import com.mgammon.tidalregearsdemo.exceptions.DuplicateBuildException;
import com.mgammon.tidalregearsdemo.exceptions.NotFoundByIdException;
import com.mgammon.tidalregearsdemo.models.Build;
import com.mgammon.tidalregearsdemo.repositories.BuildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildService {
    private final BuildRepository buildRepository;

    @Autowired
    public BuildService(BuildRepository buildRepository) {
        this.buildRepository = buildRepository;
    }

    public List<Build> getBuilds() {
        return buildRepository.findAll();
    }

    public void addNewBuild(Build build) {
        Build foundBuild = buildRepository.findDuplicateBuild(build.getMainHand(), build.getHeadGear(), build.getChestGear(), build.getShoes(), build.getMinimumIp(), build.getMinimumTier());
        if (foundBuild != null) {
            throw new DuplicateBuildException();
        }
        buildRepository.save(build);
    }

    public Optional<Build> getBuildById(Long buildId) {
        if (buildRepository.findById(buildId).isEmpty()) {
            String entityName = "build";
            throw new NotFoundByIdException(buildId, entityName);
        }
        return buildRepository.findById(buildId);
    }


    public void deleteBuild(Long buildId) {
        buildRepository.deleteById(buildId);
    }

    public ResponseEntity<Build> updateBuild(Long buildId, Build build) {
        // the use of a DTO and something like MapStruct would absolutely be the preferred implementation here
        Build originalBuild = buildRepository.findById(buildId).orElseThrow(() -> new NotFoundByIdException(buildId, "build"));
        originalBuild.setBuildName(build.getBuildName());
        originalBuild.setBuildRole(build.getBuildRole());
        originalBuild.setMinimumTier(build.getMinimumTier());
        originalBuild.setMinimumIp(build.getMinimumIp());
        originalBuild.setHeadGear(build.getHeadGear());
        originalBuild.setChestGear(build.getChestGear());
        originalBuild.setShoes(build.getShoes());
        originalBuild.setMainHand(build.getMainHand());
        originalBuild.setOffHand(build.getOffHand());
        originalBuild.setCape(build.getCape());
        originalBuild.setFood(build.getFood());
        originalBuild.setPotion(build.getPotion());
        originalBuild.setMount(build.getMount());
        final Build updatedBuild = buildRepository.save(originalBuild);
        return new ResponseEntity<>(updatedBuild, HttpStatus.OK);
    }
}
