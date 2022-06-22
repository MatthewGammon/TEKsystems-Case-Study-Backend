package com.mgammon.tidalregearsdemo.controllers;

import com.mgammon.tidalregearsdemo.models.OffHand;
import com.mgammon.tidalregearsdemo.services.OffHandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/offHand")
public class OffHandController {

    private final OffHandService offHandService;

    @Autowired
    public OffHandController(OffHandService offHandService) {
        this.offHandService = offHandService;
    }

    @GetMapping
    public List<OffHand> getOffHand() {
        return offHandService.getOffHand();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addNewOffHand(@RequestBody OffHand offHand) {
        offHandService.addNewOffHand(offHand);
    }

    @GetMapping("{offHandId}")
    public Optional<OffHand> getOffHandById(@PathVariable Long offHandId) {
        return offHandService.getOffHandById(offHandId);
    }
}
