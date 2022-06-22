package com.mgammon.tidalregearsdemo.repositories;

import com.mgammon.tidalregearsdemo.models.Chest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChestRepository extends JpaRepository<Chest, Long> {
}
