package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.exceptions.NotFoundByIdException;
import com.mgammon.tidalregears.models.Chest;
import com.mgammon.tidalregears.repositories.ChestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChestService {
    private final ChestRepository chestRepository;

    @Autowired
    public ChestService(ChestRepository chestRepository) {
        this.chestRepository = chestRepository;
    }

    public List<Chest> getChestGear() {
        return chestRepository.findAll();
    }

    public void addNewChestGear(Chest chest) {
        chestRepository.save(chest);
    }

    public Optional<Chest> getChestGearById(Long chestId) {
        if (chestRepository.findById(chestId).isEmpty()) {
            String entityName = "chest";
            throw new NotFoundByIdException(chestId, entityName);
        }
        return chestRepository.findById(chestId);
    }
}
