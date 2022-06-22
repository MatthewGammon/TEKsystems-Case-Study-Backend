package com.mgammon.tidalregearsdemo.repositories;


import com.mgammon.tidalregearsdemo.models.OffHand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffHandRepository extends JpaRepository<OffHand, Long> {
}
