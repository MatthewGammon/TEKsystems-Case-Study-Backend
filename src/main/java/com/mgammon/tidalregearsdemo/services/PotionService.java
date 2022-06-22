package com.mgammon.tidalregearsdemo.services;

import com.mgammon.tidalregearsdemo.exceptions.NotFoundByIdException;
import com.mgammon.tidalregearsdemo.models.Potion;
import com.mgammon.tidalregearsdemo.repositories.PotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PotionService {
    private final PotionRepository potionRepository;

    @Autowired
    public PotionService(PotionRepository potionRepository) {
        this.potionRepository = potionRepository;
    }

    public List<Potion> getPotions() {
        return potionRepository.findAll();
    }

    public void addNewPotion(Potion potion) {
        potionRepository.save(potion);
    }

    public Optional<Potion> getPotionById(Long potionId) {
        if (potionRepository.findById(potionId).isEmpty()) {
            String entityName = "potion";
            throw new NotFoundByIdException(potionId, entityName);
        }
        return potionRepository.findById(potionId);
    }

}
