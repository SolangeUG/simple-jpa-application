package org.java.training.service;

import org.java.training.converter.UserConverter;
import org.java.training.domain.User;
import org.java.training.dto.UserDto;
import org.java.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Our user service implementation
 * @author Solange U. Gasengayire
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Find a user by their id
     *
     * @param id the user id
     * @return the corresponding user
     */
    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.getOne(id);
        return UserConverter.convert(user);
    }

    /**
     * Find a user by their username
     *
     * @param username the username
     * @return the corresponding user
     */
    @Override
    public UserDto getUserByUserName(String username) {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            return null;
        }
        return UserConverter.convert(user);
    }

    /**
     * Find a user by their firstname
     *
     * @param firstname the firstname
     * @return the corresponding user
     */
    @Override
    public List<UserDto> getUserByFirstName(String firstname) {
        List<User> users = userRepository.findByFirstName(firstname);
        if (users == null) {
            return null;
        }
        return users
                .stream()
                .map(UserConverter::convert)
                .collect(Collectors.toList());
    }

    /**
     * Find a user by their lastname
     *
     * @param lastname the lastname
     * @return the corresponding user
     */
    @Override
    public List<UserDto> getUserByLastName(String lastname) {
        List<User> users = userRepository.findByLastName(lastname);
        if (users == null) {
            return null;
        }
        return users
                .stream()
                .map(UserConverter::convert)
                .collect(Collectors.toList());
    }

    /**
     * Save a user
     *
     * @param userDto the given user
     * @return the saved user
     */
    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = UserConverter.convert(userDto);
        User result = userRepository.save(user);
        return UserConverter.convert(result);
    }

    /**
     * Find all users
     *
     * @return all users
     */
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(UserConverter::convert)
                .collect(Collectors.toList());
    }

    /**
     * Update a user
     *
     * @param userDto the given user
     * @return the updated user
     */
    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = UserConverter.convert(userDto);
        User updatedUser = userRepository.save(user);
        return UserConverter.convert(updatedUser);
    }
}
