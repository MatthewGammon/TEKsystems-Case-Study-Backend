package com.mgammon.tidalregearsdemo.controllers;

import com.mgammon.tidalregearsdemo.models.Potion;
import com.mgammon.tidalregearsdemo.services.PotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/potions")
public class PotionController {
    private final PotionService potionService;

    @Autowired
    public PotionController(PotionService potionService) {
        this.potionService = potionService;
    }

    @GetMapping
    public List<Potion> getPotions() {
        return potionService.getPotions();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addNewPotion(@RequestBody Potion potion) {
        potionService.addNewPotion(potion);
    }

    @GetMapping("{potionId}")
    public Optional<Potion> getPotionById(@PathVariable Long potionId) {
        return potionService.getPotionById(potionId);
    }
}
