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
     * Find a user by their username
     * @param username the username
     * @return the corresponding user
     */
    UserDto getUserByUserName(String username);

    /**
     * Find a user by their firstname
     * @param firstname the firstname
     * @return the corresponding user
     */
    List<UserDto> getUserByFirstName(String firstname);

    /**
     * Find a user by their lastname
     * @param lastname the lastname
     * @return the corresponding user
     */
    List<UserDto> getUserByLastName(String lastname);

    /**
     * Save a user
     * @param userDto the given user
     * @return the saved user
     */
    UserDto saveUser(UserDto userDto);

    /**
     * Find all users
     * @return all users
     */
    List<UserDto> getAllUsers();

    /**
     * Update a user
     * @param userDto the given user
     * @return the updated user
     */
    UserDto updateUser(UserDto userDto);

}
