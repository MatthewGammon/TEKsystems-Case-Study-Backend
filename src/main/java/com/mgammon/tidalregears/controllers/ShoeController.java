package com.mgammon.tidalregears.controllers;

import com.mgammon.tidalregears.models.Shoe;
import com.mgammon.tidalregears.services.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shoes")
public class ShoeController {

    private final ShoeService shoeService;

    @Autowired
    public ShoeController(ShoeService shoeService) {
        this.shoeService = shoeService;
    }

    @GetMapping
    public List<Shoe> getShoes() {
        return shoeService.getShoes();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addNewShoes(@RequestBody Shoe shoe) {
        shoeService.addNewShoes(shoe);
    }

    @GetMapping("{shoeId}")
    public Optional<Shoe> getShoesById(@PathVariable Long shoeId) {
        return shoeService.getShoesById(shoeId);
    }
}
