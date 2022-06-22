package com.mgammon.tidalregearsdemo.services;

import com.mgammon.tidalregearsdemo.exceptions.NotFoundByIdException;
import com.mgammon.tidalregearsdemo.exceptions.PropertyIsNullException;
import com.mgammon.tidalregearsdemo.models.MainHand;
import com.mgammon.tidalregearsdemo.repositories.MainHandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MainHandService {
    private final MainHandRepository mainHandRepository;

    @Autowired
    public MainHandService(MainHandRepository mainHandRepository) {
        this.mainHandRepository = mainHandRepository;
    }

    public List<MainHand> getMainHand() {
        return mainHandRepository.findAll();
    }

    public void addNewMainHand(MainHand mainHand) {
        if (mainHand.getMainHandName() == null || mainHand.getMainHandName().isEmpty()) {
            throw new PropertyIsNullException();
        }
        mainHandRepository.save(mainHand);
    }

    public Optional<MainHand> getMainHandById(Long mainHandId) {
        if (mainHandRepository.findById(mainHandId).isEmpty()) {
            String entityName = "main hand";
            throw new NotFoundByIdException(mainHandId, entityName);
        }
        return mainHandRepository.findById(mainHandId);
    }
}
