package com.mgammon.tidalregearsdemo.services;

import com.mgammon.tidalregearsdemo.exceptions.NotFoundByIdException;
import com.mgammon.tidalregearsdemo.models.Regear;
import com.mgammon.tidalregearsdemo.repositories.RegearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegearService {
    private final RegearRepository regearRepository;

    @Autowired
    public RegearService(RegearRepository regearRepository) {
        this.regearRepository = regearRepository;
    }

    public List<Regear> getRegears() {
        return regearRepository.findAll();
    }

    public void addNewRegear(Regear regear) {
        regearRepository.save(regear);
    }

    public Optional<Regear> getRegearById(Long regearId) {
        if (regearRepository.findById(regearId).isEmpty()) {
            String entityName = "regear";
            throw new NotFoundByIdException(regearId, entityName);
        }

        return regearRepository.findById(regearId);
    }
}
