package com.mgammon.tidalregears.repositories;

import com.mgammon.tidalregears.models.ERole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback
public class RoleRepositoryTest {

    @Autowired
    RoleRepository roleRepository;

    // uses .valueOf to pass in a String representing a Role name to the findByName method and checks if a result is present
    @Test
    public void testFindByName() {
        boolean roleName = roleRepository.findByName(ERole.valueOf("ROLE_ADMIN")).isPresent();
        assertTrue(roleName);
    }

}
