package com.mgammon.tidalregears.repositories;

import com.mgammon.tidalregears.models.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Long> {
}
