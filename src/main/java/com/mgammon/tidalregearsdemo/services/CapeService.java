package com.mgammon.tidalregearsdemo.services;

import com.mgammon.tidalregearsdemo.exceptions.NotFoundByIdException;
import com.mgammon.tidalregearsdemo.exceptions.PropertyIsNullException;
import com.mgammon.tidalregearsdemo.models.Cape;
import com.mgammon.tidalregearsdemo.repositories.CapeRepository;
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
        if (cape.getCapeName() == null || cape.getCapeName().isEmpty()) {
            throw new PropertyIsNullException();
        }
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
