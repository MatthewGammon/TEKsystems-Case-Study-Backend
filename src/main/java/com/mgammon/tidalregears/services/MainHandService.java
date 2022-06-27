package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.exceptions.NotFoundByIdException;
import com.mgammon.tidalregears.models.MainHand;
import com.mgammon.tidalregears.repositories.MainHandRepository;
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
