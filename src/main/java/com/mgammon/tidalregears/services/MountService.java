package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.exceptions.NotFoundByIdException;
import com.mgammon.tidalregears.models.Mount;
import com.mgammon.tidalregears.repositories.MountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MountService {
    private final MountRepository mountRepository;

    @Autowired
    public MountService(MountRepository mountRepository) {
        this.mountRepository = mountRepository;
    }

    public List<Mount> getMounts() {
        return mountRepository.findAll();
    }

    public void addNewMount(Mount mount) {
        mountRepository.save(mount);
    }

    public Optional<Mount> findMountById(Long mountId) {
        String entityName = "mount";
        if (mountRepository.findById(mountId).isEmpty()) {
            throw new NotFoundByIdException(mountId, entityName);
        }
        return mountRepository.findById(mountId);
    }
}
