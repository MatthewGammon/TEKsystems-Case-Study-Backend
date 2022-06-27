package com.mgammon.tidalregearsdemo.controllers;

import com.mgammon.tidalregearsdemo.models.Build;
import com.mgammon.tidalregearsdemo.services.BuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/builds")
public class BuildController {
    private final BuildService buildService;

    @Autowired
    public BuildController(BuildService buildService) {
        this.buildService = buildService;
    }

    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    @GetMapping
    public List<Build> getBuilds() {
        return buildService.getBuilds();
    }

    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    @GetMapping("{buildId}")
    public Optional<Build> getBuildById(@PathVariable Long buildId) {
        return buildService.getBuildById(buildId);
    }


    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addNewBuild(@RequestBody Build build) {
        buildService.addNewBuild(build);
    }


    @PutMapping("{buildId}")
    public ResponseEntity<Build> updateBuild(@PathVariable Long buildId, @RequestBody Build build) {
        return buildService.updateBuild(buildId, build);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{buildId}")
    public void deleteBuild(@PathVariable Long buildId) {
        buildService.deleteBuild(buildId);
    }
}
