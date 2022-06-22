package com.mgammon.tidalregearsdemo.controllers;

import com.mgammon.tidalregearsdemo.models.Head;
import com.mgammon.tidalregearsdemo.services.HeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/headGear")
public class HeadController {
    private final HeadService headService;

    @Autowired
    public HeadController(HeadService headService) {this.headService = headService;}

    @GetMapping
    public List<Head> getHeadGear(){
        return headService.getHeadGear();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addNewHeadGear(@RequestBody Head head){
        headService.addNewHeadGear(head);
    }

    @GetMapping("{headId}")
    public Optional<Head> getHeadGearById(@PathVariable Long headId){
        return headService.getHeadGearById(headId);
    }

}
