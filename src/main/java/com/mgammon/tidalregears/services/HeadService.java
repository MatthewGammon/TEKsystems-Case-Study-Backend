package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.exceptions.NotFoundByIdException;
import com.mgammon.tidalregears.models.Head;
import com.mgammon.tidalregears.repositories.HeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeadService {
    private final HeadRepository headRepository;

    @Autowired
    public HeadService(HeadRepository headRepository) {
        this.headRepository = headRepository;
    }

    public List<Head> getHeadGear() {
        return headRepository.findAll();
    }

    public void addNewHeadGear(Head head) {
        headRepository.save(head);

    }

    public Optional<Head> getHeadGearById(Long headId) {
        if (headRepository.findById(headId).isEmpty()) {
            String entityName = "head";
            throw new NotFoundByIdException(headId, entityName);
        }
        return headRepository.findById(headId);
    }
}
