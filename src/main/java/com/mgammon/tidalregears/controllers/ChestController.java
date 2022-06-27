package com.mgammon.tidalregears.controllers;

import com.mgammon.tidalregears.models.Chest;
import com.mgammon.tidalregears.services.ChestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chestGear")
public class ChestController {
    private final ChestService chestService;

    @Autowired
    public ChestController(ChestService chestService) {
        this.chestService = chestService;
    }

    @GetMapping
    public List<Chest> getChestGear() {
        return chestService.getChestGear();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addNewChestGear(@RequestBody Chest chest) {
        chestService.addNewChestGear(chest);
    }

    @GetMapping("{chestId}")
    public Optional<Chest> getChestGearById(@PathVariable Long chestId) {
        return chestService.getChestGearById(chestId);
    }
}
