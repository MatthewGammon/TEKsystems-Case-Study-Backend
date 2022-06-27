package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.exceptions.NotFoundByIdException;
import com.mgammon.tidalregears.models.Cape;
import com.mgammon.tidalregears.repositories.CapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapeService {
    private final CapeRepository capeRepository;

    @Autowired
    public CapeService(CapeRepository capeRepository) {
        this.capeRepository = capeRepository;
    }

    public List<Cape> getCapes() {
        return capeRepository.findAll();
    }

    public void addNewCape(Cape cape) {
        capeRepository.save(cape);

    }

    public Optional<Cape> getCapeById(Long capeId) {
        if (capeRepository.findById(capeId).isEmpty()) {
            String entityName = "cape";
            throw new NotFoundByIdException(capeId, entityName);
        }
        return capeRepository.findById(capeId);
    }
}
