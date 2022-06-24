package com.mgammon.tidalregearsdemo.repositories;

import com.mgammon.tidalregearsdemo.models.Build;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildRepository extends JpaRepository<Build, Long> {
    // this method is for use in the RegearService to validate a regear request
    @Query(value = "SELECT b FROM Build b WHERE b.mainHand = ?1 and b.headGear = ?2 and b.chestGear = ?3 and b.shoes = ?4")
    Build findBuildByRequiredGear(String mainHand, String headGear, String chestGear, String shoes);

    // this method is used in the BuildService to ensure no duplicate builds are posted.
    // the criteria it uses are the 4 main items of the build (main hand, head, chest, shoes) as well as item power and minimum tier.
    // Several column values could be different (e.g. Mount could be Swiftclaw in one build and Black Panther in another), but still fail this check because the main values are identical.
    // The secondary items take a back seat to ensuring unique builds are created
    @Query(value = "SELECT b FROM Build b WHERE b.mainHand = ?1 and b.headGear = ?2 and b.chestGear =?3 and b.shoes =?4 and b.minimumIp = ?5 and b.minimumTier = ?6")
    Build findDuplicateBuild(String mainHand, String headGear, String chestGear, String shoes, Integer minimumIp, Integer minimumTier);
}
