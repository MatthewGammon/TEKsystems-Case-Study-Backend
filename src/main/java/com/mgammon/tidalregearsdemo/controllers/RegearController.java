package com.mgammon.tidalregearsdemo.controllers;

import com.mgammon.tidalregearsdemo.models.Regear;
import com.mgammon.tidalregearsdemo.services.RegearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/regears")
public class RegearController {

    private final RegearService regearService;

    @Autowired
    public RegearController(RegearService regearService) {
        this.regearService = regearService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public List<Regear> getRegears() {
        return regearService.getRegears();
    }

    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    @GetMapping("{regearId}")
    public Optional<Regear> getRegearById(@PathVariable Long regearId) {
        return regearService.getRegearById(regearId);
    }

    @PostMapping("/request")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addNewRegear(@RequestBody Regear regear) {
        regearService.addNewRegear(regear);
    }

    @PutMapping("{regearId}")
    public ResponseEntity<Regear> updateRegearStatus(@PathVariable Long regearId, @RequestBody Regear regear) {
        return regearService.updateRegearStatus(regearId, regear);
    }
}
