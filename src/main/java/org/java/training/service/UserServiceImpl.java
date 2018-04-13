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
    UserRepository userRepository;

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
     * Save a user
     *
     * @param userDto the given user
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
}
