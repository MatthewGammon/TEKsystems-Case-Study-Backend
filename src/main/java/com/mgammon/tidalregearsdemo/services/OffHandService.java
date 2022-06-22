package com.mgammon.tidalregearsdemo.services;

import com.mgammon.tidalregearsdemo.exceptions.NotFoundByIdException;
import com.mgammon.tidalregearsdemo.exceptions.PropertyIsNullException;
import com.mgammon.tidalregearsdemo.models.OffHand;
import com.mgammon.tidalregearsdemo.repositories.OffHandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffHandService {
    private final OffHandRepository offHandRepository;

    @Autowired
    public OffHandService(OffHandRepository offHandRepository) {
        this.offHandRepository = offHandRepository;
    }

    public List<OffHand> getOffHand() {
        return offHandRepository.findAll();
    }

    public void addNewOffHand(OffHand offHand) {
        if (offHand.getOffHandName() == null || offHand.getOffHandName().isEmpty()) {
            throw new PropertyIsNullException();
        }
        offHandRepository.save(offHand);
    }

    public Optional<OffHand> getOffHandById(Long offHandId) {
        if (offHandRepository.findById(offHandId).isEmpty()) {
            String entityName = "off hand";
            throw new NotFoundByIdException(offHandId, entityName);
        }
        return offHandRepository.findById(offHandId);
    }
}
