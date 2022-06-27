package com.mgammon.tidalregears.repositories;

import com.mgammon.tidalregears.models.Chest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChestRepository extends JpaRepository<Chest, Long> {
}
