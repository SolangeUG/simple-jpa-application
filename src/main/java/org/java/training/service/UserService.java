package org.java.training.service;

import org.java.training.dto.UserDto;

import java.util.List;

/**
 * A simple user service interface
 * @author Solange U. Gasengayire
 */
public interface UserService {

    /**
     * Find a user by their id
     * @param id the user id
     * @return the corresponding user
     */
    UserDto getUserById(Long id);

    /**
     * Save a user
     * @param userDto the given user
     */
    UserDto saveUser(UserDto userDto);

    /**
     * Find all users
     * @return all users
     */
    List<UserDto> getAllUsers();

}
