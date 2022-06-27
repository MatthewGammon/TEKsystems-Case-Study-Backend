package com.mgammon.tidalregears.controllers;

import com.mgammon.tidalregears.models.Cape;
import com.mgammon.tidalregears.services.CapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/capes")
public class CapeController {
    private final CapeService capeService;

    @Autowired
    public CapeController(CapeService capeService) {
        this.capeService = capeService;
    }

    @GetMapping
    public List<Cape> getCapes() {
        return capeService.getCapes();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addNewCape(@RequestBody Cape cape) {
        capeService.addNewCape(cape);
    }

    @GetMapping("{capeId}")
    public Optional<Cape> getCapeById(@PathVariable Long capeId) {
        return capeService.getCapeById(capeId);
    }
}
