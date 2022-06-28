package com.mgammon.tidalregears.repositories;

import com.mgammon.tidalregears.models.Build;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback
public class BuildRepositoryTest {
    private String mainHand;
    private String headGear;
    private String chestGear;
    private String shoes;
    private Integer minimumIp;
    private Integer minimumTier;

    private Build build1;

    @Autowired
    BuildRepository buildRepository;

    @BeforeEach
    public void initialize() {
        Build build = new Build("Cynical Fallen", "Healer", 8, 1350, "Judicator Helmet", "Demon Armor", "Royal Boots", "Greataxe", null, "Fort Sterling Cape", "Pork Omelette", "Resistance Potion", "Swiftclaw");
        build1 = buildRepository.save(build);

        mainHand = build.getMainHand();
        headGear = build.getHeadGear();
        chestGear = build.getChestGear();
        shoes = build.getShoes();
        minimumIp = build.getMinimumIp();
        minimumTier = build.getMinimumTier();
    }

    // this test will persist a build as I am unable to rollback my transactions properly.
    // please delete the newly saved build before running the next test
    // this method is used to find a build that has column values matching the 4 main pieces of gear a player is wearing when they submit a regear request
    @Test
    public void testFindBuildByRequiredGear() {
        Build foundBuild = buildRepository.findBuildByRequiredGear(mainHand, headGear, chestGear, shoes);

        assertEquals(build1, foundBuild);
    }

    // this test will fail due to non non unique rows being returned if the build created in the previous test is not deleted
    // the methods look very similar, but this one is used to find builds with different names, food, potions, etc, but with the same 4 main components (mainHand, headGear, chestGear, and shoes, as well as minimumIp and minimumTier)
    // those 6 traits essentially make up what is considered a "duplicate" build even though many values are still different

    @Test
    public void testFindDuplicateBuild() {
        Build foundBuild = buildRepository.findDuplicateBuild(mainHand, headGear, chestGear, shoes, minimumIp, minimumTier);

        assertEquals(build1, foundBuild);


    }
}
