package org.java.training.repository;

import org.java.training.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is the JPA specific repository interface to manage our User entity
 * @author Solange U. Gasengayire
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find a user by their username
     * @param userName the username criterion
     * @return the corresponding user
     */
    default User findByUserName(String userName) {
        // TODO : implement
        return  null;
    }

    /**
     * Find a user by their first name
     * @param firstName the firstname criterion
     * @return the corresponding user
     */
    default User findByFirstName(String firstName) {
        // TODO: implement
        return null;
    }

    /**
     * Find a user by their last name
     * @param lastName the lastname criterion
     * @return the corresponding user
     */
    default User findByLastName(String lastName) {
        // TODO: implement
        return null;
    }
}
