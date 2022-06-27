package com.mgammon.tidalregears.repositories;

import com.mgammon.tidalregears.models.Regear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegearRepository extends JpaRepository<Regear, Long> {

    @Query(value = "SELECT r FROM Regear r WHERE r.eventId = ?1")
    Regear findByEventId(String eventId);


}
