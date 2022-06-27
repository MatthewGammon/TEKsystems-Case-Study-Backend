package com.mgammon.tidalregears.controllers;

import com.mgammon.tidalregears.models.Mount;
import com.mgammon.tidalregears.services.MountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mounts")
public class MountController {
    private final MountService mountService;

    @Autowired
    public MountController(MountService mountService) {
        this.mountService = mountService;
    }

    @GetMapping
    public ResponseEntity<List<Mount>> getMounts() {
        List<Mount> listOfAllMounts = mountService.getMounts();
        return new ResponseEntity<List<Mount>>(listOfAllMounts, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addNewMount(@RequestBody Mount mount) {
        mountService.addNewMount(mount);
    }

    @GetMapping("{mountId}")
    public Optional<Mount> getMountById(@PathVariable Long mountId) {
        return mountService.findMountById(mountId);
    }
}
