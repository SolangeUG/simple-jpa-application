package org.java.training.repository;

import org.java.training.domain.Role;
import org.java.training.domain.User;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * UserRepository tests class
 * @author Solange U. Gasengayire
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("Should create a new user and return an updated list of users")
    public void shouldCreateUserAndReturnUpdatedUserList() {
        User user = new User("markKnopfler", "Mark", "Knopfler");
        Long id = (Long) entityManager.persistAndGetId(user);
        entityManager.flush();

        List<User> users = userRepository.findAll();
        assertAll("List of users",
                () -> assertNotNull(users),
                () -> assertEquals(1, users.size()),
                () -> assertEquals(id, users.get(0).getUserId())
        );
    }

    @Test
    @DisplayName("Should delete a user and return an updated list of users")
    public void shouldDeleteUserAndReturnUpdatedUserList() {
        User userOne = new User("maverick", "Bret", "Maverick");
        User userTwo = new User("tomMullen", "Tom", "Mullen");
        Long idOne = (Long) entityManager.persistAndGetId(userOne);
        Long idTwo = (Long) entityManager.persistAndGetId(userTwo);
        entityManager.persist(userTwo);

        userRepository.deleteById(idTwo);
        List<User> users = userRepository.findAll();
        assertAll("Delete a user by id",
                () -> assertNotNull(users),
                () -> assertEquals(1, users.size()),
                () -> assertEquals(idOne, users.get(0).getUserId())
        );
    }

    @Test
    @DisplayName("Should create a user with specified roles")
    public void shouldCreateUserWithSpecifiedRoles() {
        User alias = new User("sidneyBristow", "Sidney", "Bristow");

        Role spy = new Role("Spy");
        Role doubleAgent = new Role("Double Agent");
        List<Role> roles = new ArrayList<>();
        roles.add(spy);
        roles.add(doubleAgent);

        alias.setRoles(roles);
        Long id = (Long) entityManager.persistAndGetId(alias);

        User sidney = userRepository.getOne(id);
        assertAll("Test user roles",
                () -> assertNotNull(sidney),
                () -> assertEquals("Sidney", sidney.getFirstName()),
                () -> assertNotNull(sidney.getRoles()),
                () -> assertEquals(2, sidney.getRoles().size())
        );
    }
}
