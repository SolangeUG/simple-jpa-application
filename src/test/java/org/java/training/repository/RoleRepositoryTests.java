package org.java.training.repository;

import org.java.training.domain.Role;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * RoleRepository tests class
 * @author Solange U. Gasengayire
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class RoleRepositoryTests {

    @Autowired
    private RoleRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("Should create a role and return an updated list of roles")
    public void shouldCreateRoleAndReturnUpdatedRoleList() {
        Role role = new Role("Administrator");
        Long id = (Long) entityManager.persistAndGetId(role);
        entityManager.flush();

        List<Role> roles = repository.findAll();
        assertAll("List of roles",
                () -> assertNotNull(roles),
                () -> assertEquals(1, roles.size()),
                () -> assertEquals(id, roles.get(0).getRoleId())
        );
    }

    @Test
    @DisplayName("Should create a new role and retrieve it by its id")
    public void shouldCreateRoleAndRetrieveItById() {
        Role role = new Role("Senior Manager");
        Long id = (Long) entityManager.persistAndGetId(role);
        entityManager.flush();

        Role result = repository.getOne(id);
        assertAll("Get role by id",
                () -> assertNotNull(result),
                () -> assertEquals(Long.valueOf(id), result.getRoleId())
        );
    }

    @Test
    @DisplayName("Should delete a role and return an updated list of roles")
    public void shouldDeleteRoleAndReturnUpdatedRoleList() {
        Role roleOne = new Role("Administrator");
        Long id = (Long) entityManager.persistAndGetId(roleOne);
        Role roleTwo = new Role("User");
        entityManager.persist(roleTwo);
        entityManager.flush();

        repository.deleteById(id);
        List<Role> roles = repository.findAll();
        assertAll("Delete a role by id",
                () -> assertNotNull(roles),
                () -> assertEquals(1, roles.size()),
                () -> assertNotEquals(id, roles.get(0).getRoleId())
        );
    }

}
