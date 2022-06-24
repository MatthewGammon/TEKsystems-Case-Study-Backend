package com.mgammon.tidalregearsdemo.repositories;

import com.mgammon.tidalregearsdemo.models.Build;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildRepository extends JpaRepository<Build, Long> {
    @Query(value = "SELECT b FROM Build b WHERE b.mainHand = ?1 and b.headGear = ?2 and b.chestGear = ?3 and b.shoes = ?4")
    Build findBuildByRequiredGear(String mainHand, String headGear, String chestGear, String shoes);
}
