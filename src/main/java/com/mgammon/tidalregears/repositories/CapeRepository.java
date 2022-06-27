package com.mgammon.tidalregears.repositories;

import com.mgammon.tidalregears.models.Cape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapeRepository extends JpaRepository<Cape, Long> {
}
