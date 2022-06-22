package com.mgammon.tidalregearsdemo.services;

import com.mgammon.tidalregearsdemo.exceptions.NotFoundByIdException;
import com.mgammon.tidalregearsdemo.exceptions.PropertyIsNullException;
import com.mgammon.tidalregearsdemo.models.Head;
import com.mgammon.tidalregearsdemo.repositories.HeadRepository;
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
        if (head.getHeadName() == null || head.getHeadName().isEmpty()) {
            throw new PropertyIsNullException();
        }
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
