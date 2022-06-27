package com.mgammon.tidalregears.repositories;

import com.mgammon.tidalregears.models.Potion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotionRepository extends JpaRepository<Potion, Long> {
}
