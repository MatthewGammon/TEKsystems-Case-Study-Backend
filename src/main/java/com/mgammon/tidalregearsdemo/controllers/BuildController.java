package com.mgammon.tidalregearsdemo.controllers;

import com.mgammon.tidalregearsdemo.models.Build;
import com.mgammon.tidalregearsdemo.services.BuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/builds")
public class BuildController {
    private final BuildService buildService;

    @Autowired
    public BuildController(BuildService buildService) {
        this.buildService = buildService;
    }

    @GetMapping
    public List<Build> getBuilds() {
        return buildService.getBuilds();
    }

    @GetMapping("{buildId}")
    public Optional<Build> getBuildById(@PathVariable Long buildId) {
        return buildService.getBuildById(buildId);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addNewBuild(@RequestBody Build build) {
        buildService.addNewBuild(build);
    }

    @DeleteMapping("{buildId}")
    public void deleteBuild(@PathVariable Long buildId){
        buildService.deleteBuild(buildId);
    }
}
