package com.mgammon.tidalregears.repositories;

import com.mgammon.tidalregears.models.Head;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadRepository extends JpaRepository<Head, Long> {
}
