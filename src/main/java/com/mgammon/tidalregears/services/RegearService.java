package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.exceptions.*;
import com.mgammon.tidalregears.models.Build;
import com.mgammon.tidalregears.models.Regear;
import com.mgammon.tidalregears.repositories.BuildRepository;
import com.mgammon.tidalregears.repositories.RegearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegearService {
    private final RegearRepository regearRepository;

    private final BuildRepository buildRepository;

    @Autowired
    public RegearService(RegearRepository regearRepository, BuildRepository buildRepository) {
        this.regearRepository = regearRepository;
        this.buildRepository = buildRepository;
    }

    public List<Regear> getRegears() {
        return regearRepository.findAll();
    }


    public void addNewRegear(Regear regear) {
        // retrieve eventId representing the battle id where the player was killed
        String eventId = regear.getEventId();

        // if a regear request with the given eventId is found, a regear submission has already been made. throw custom exception.
        Regear foundRegear = regearRepository.findByEventId(eventId);
        if (foundRegear != null) {
            String entityName = "Regear";
            throw new AlreadyExistsException(entityName, eventId);
        }

        // if no submission exists, looks for a build containing the four main components of a valid build
        Build foundBuild = buildRepository.findBuildByRequiredGear(regear.getMainHand(), regear.getHeadGear(), regear.getChestGear(), regear.getShoes());
        // if no build is returned, the player is not wearing proper gear, so return a custom exception.
        if (foundBuild == null) {
            throw new InvalidBuildException();
        }

        // get values to compare the player's itemPower and gear tier equivalent vs the minimum values specified for that particular build
        Integer itemPower = regear.getItemPower();
        Integer minimumIP = foundBuild.getMinimumIp();
        Integer minTierEquiv = foundBuild.getMinimumTier();
        Integer mainEquiv = regear.getMainEquivalent();
        Integer headEquiv = regear.getHeadEquivalent();
        Integer chestEquiv = regear.getChestEquivalent();
        Integer shoesEquiv = regear.getShoesEquivalent();

        // first check item power as it is more important
        if (itemPower < minimumIP) {
            throw new ItemPowerTooLowException(itemPower, minimumIP);
        }

        // if the item power is high enough, check that all of their main items meet or exceed the minimum tier equivalent.
        if (mainEquiv < minTierEquiv | headEquiv < minTierEquiv | chestEquiv < minTierEquiv | shoesEquiv < minTierEquiv) {
            throw new TierTooLowException(minTierEquiv);
        }

        // if the player's gear is all of the correct type and power levels, save the regear request.
        regearRepository.save(regear);
    }

    public Optional<Regear> getRegearById(Long regearId) {
        if (regearRepository.findById(regearId).isEmpty()) {
            String entityName = "regear";
            throw new NotFoundByIdException(regearId, entityName);
        }

        return regearRepository.findById(regearId);
    }

    public ResponseEntity<Regear> updateRegearStatus(Long regearId, Regear regear) {
        // query db for a regear with the provided id. throw custom exception if not found
        Regear regearRequest = regearRepository.findById(regearId).orElseThrow(() -> new NotFoundByIdException(regearId, "regear"));
        // if a regear request is found, set the status of that request to the status on the regear object passed in from the request
        // this will either update to "approved" or "rejected"
        regearRequest.setStatus(regear.getStatus());
        // save the updated request
        final Regear updatedRegear = regearRepository.save(regearRequest);
        // return the updated request and a 200 status
        return new ResponseEntity<>(updatedRegear, HttpStatus.OK);
    }
}
