package org.java.training.repository;

import org.java.training.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is the JPA specific repository interface to manage our Role entity
 * @author Solange U. Gasengayire
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
