package com.mgammon.tidalregearsdemo.controllers;

import com.mgammon.tidalregearsdemo.models.MainHand;
import com.mgammon.tidalregearsdemo.services.MainHandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mainHand")
public class MainHandController {

    private final MainHandService mainHandService;

    @Autowired
    public MainHandController(MainHandService mainHandService) {
        this.mainHandService = mainHandService;
    }

    @GetMapping
    public List<MainHand> getWeapons() {
        return mainHandService.getMainHand();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addNewWeapon(@RequestBody MainHand mainHand) {
        mainHandService.addNewMainHand(mainHand);
    }

    @GetMapping("{weaponId}")
    public Optional<MainHand> getGearById(@PathVariable Long weaponId) {
        return mainHandService.getMainHandById(weaponId);
    }
}
