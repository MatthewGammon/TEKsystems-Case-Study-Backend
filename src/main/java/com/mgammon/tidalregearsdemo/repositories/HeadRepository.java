package com.mgammon.tidalregearsdemo.repositories;

import com.mgammon.tidalregearsdemo.models.Head;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadRepository extends JpaRepository<Head, Long> {
}
