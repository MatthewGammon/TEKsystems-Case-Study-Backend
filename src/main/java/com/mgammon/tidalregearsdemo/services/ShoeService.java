package com.mgammon.tidalregearsdemo.services;

import com.mgammon.tidalregearsdemo.exceptions.NotFoundByIdException;
import com.mgammon.tidalregearsdemo.models.Shoe;
import com.mgammon.tidalregearsdemo.repositories.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoeService {
    private final ShoeRepository shoeRepository;

    @Autowired
    public ShoeService(ShoeRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }

    public List<Shoe> getShoes() {
        return shoeRepository.findAll();
    }

    public void addNewShoes(Shoe shoe) {
        shoeRepository.save(shoe);
    }

    public Optional<Shoe> getShoesById(Long shoeId) {
        if (shoeRepository.findById(shoeId).isEmpty()) {
            String entityName = "shoes";
            throw new NotFoundByIdException(shoeId, entityName);
        }
        return shoeRepository.findById(shoeId);
    }


}
