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

}