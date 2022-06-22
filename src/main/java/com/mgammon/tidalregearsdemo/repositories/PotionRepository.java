package com.mgammon.tidalregearsdemo.repositories;

import com.mgammon.tidalregearsdemo.models.Potion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotionRepository extends JpaRepository<Potion, Long> {
}
