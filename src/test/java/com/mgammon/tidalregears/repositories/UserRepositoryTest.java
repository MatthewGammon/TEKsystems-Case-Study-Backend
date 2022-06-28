package com.mgammon.tidalregears.repositories;

import com.mgammon.tidalregears.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback
public class UserRepositoryTest {
    private User user;

    private String userName;

    private String userEmail;

    @Autowired
    UserRepository userRepository;

    // the goal with these tests is to initialize a new user and set the class fields before each test is run
    // the user would then be deleted after each test to ensure that a duplicate user was not being created
    // because I am unable to rollback the transaction, the user persists and the second and third tests will throw errors
    // I could initialize a user and fields in the first test (testFindByUsername) and then the following tests would pass
    // that would rely on the tests always being run in order, which is not guaranteed, but probably leads to the desired results more often

    // I fully intend on resolving this issue so that the full test class can be run without any manual manipulation of the database

    @BeforeEach
    public void initialize() {
        user = new User("John", "john@gmail.com", "test123456");
        userRepository.save(user);
        userName = user.getUsername();
        userEmail = user.getEmail();
    }

    @AfterEach
    public void cleanup() {
        userRepository.delete(user);
    }

    // the first test will always pass
    @Test
    public void testFindByUsername() {
        User actualUser = userRepository.findByUsername(userName);
        assertEquals(user, actualUser);
    }

    // this test will pass if the user that was persisted from the first test is deleted from the users table
    @Test
    public void testExistsByUsername() {
        assertTrue(userRepository.existsByUsername(userName));
    }

    // this test will pass if the user that was persisted from the first test is deleted from the users table
    @Test
    public void testExistsByEmail() {
        assertTrue(userRepository.existsByEmail(userEmail));
    }
}
