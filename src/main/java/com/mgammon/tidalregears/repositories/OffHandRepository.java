package com.mgammon.tidalregears.repositories;


import com.mgammon.tidalregears.models.OffHand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffHandRepository extends JpaRepository<OffHand, Long> {
}
