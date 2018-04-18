package org.java.training.service;

import org.java.training.dto.RoleDto;

import java.util.List;

/**
 * A simple role service interface
 * @author Solange U. Gasengayire
 */
public interface RoleService {

    /**
     * Find a role by their id
     * @param id role id
     * @return the corresponding role
     */
    RoleDto getRoleById(Long id);

    /**
     * Find all roles
     * @return a list of all roles
     */
    List<RoleDto> getAllRoles();

}
