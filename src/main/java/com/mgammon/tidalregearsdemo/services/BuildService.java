package com.mgammon.tidalregearsdemo.services;

import com.mgammon.tidalregearsdemo.exceptions.DuplicateBuildException;
import com.mgammon.tidalregearsdemo.exceptions.NotFoundByIdException;
import com.mgammon.tidalregearsdemo.models.Build;
import com.mgammon.tidalregearsdemo.repositories.BuildRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
