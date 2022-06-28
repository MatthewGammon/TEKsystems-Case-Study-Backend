package com.mgammon.tidalregears.services;

import com.mgammon.tidalregears.models.User;
import com.mgammon.tidalregears.repositories.UserRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class UserDetailsServiceTest {

    @Autowired
    UserRepository userRepository;

    // parameterized test to test multiple values, in this case multiple valid usernames
    @ParameterizedTest
    @ValueSource(strings = {"matthew", "CynicalEntity"})
    public void testLoadByUsername(String input) {
        User user1 = userRepository.findByUsername(input);
        assertEquals(user1.getUsername(), input);
    }
}
