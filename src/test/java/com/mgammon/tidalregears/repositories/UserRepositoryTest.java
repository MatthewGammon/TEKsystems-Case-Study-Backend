package com.mgammon.tidalregears.repositories;

import com.mgammon.tidalregears.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testFindByUsername() {
        User user1 = new User("John", "john@gmail.com", "test123456");
        userRepository.save(user1);
        String user1name = user1.getUsername();
        Optional<User> actualUser = userRepository.findByUsername(user1name);
        assertEquals(user1, actualUser);
    }
}
