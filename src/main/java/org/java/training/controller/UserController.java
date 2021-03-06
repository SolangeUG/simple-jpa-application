package org.java.training.controller;

import org.java.training.dto.UserDto;
import org.java.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Users REST API controller
 * @author Solange U. Gasengayire
 */
@CrossOrigin
@RestController
@RequestMapping(value = "${application.api.path}",
                produces = {"application/json; charset=UTF-8"})
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Return the user with a given id
     * @param userId the user id
     * @return the corresponding user
     */
    @ResponseBody
    @GetMapping(value = "${application.api.users.endpoint}/id/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Long userId) {
        UserDto userDto = userService.getUserById(userId);
        if (userDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    /**
     * Return the user with a given username
     * @param username the username
     * @return the corresponding user
     */
    @ResponseBody
    @GetMapping(value = "${application.api.users.endpoint}/username/{username}")
    public ResponseEntity<UserDto> getUserByUserName(@PathVariable("username") String username) {
        UserDto userDto = userService.getUserByUserName(username);
        if (userDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    /**
     * Return a list of all users
     * @return users list
     */
    @ResponseBody
    @GetMapping(value = "${application.api.users.endpoint}")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = userService.getAllUsers();
        if (userDtos == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    /**
     * Save a user
     * @param userDto user to save
     * @return the saved user and appropriate HTTP response
     */
    @ResponseBody
    @PostMapping(value = "${application.api.users.endpoint}")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        UserDto result = userService.saveUser(userDto);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * Update a user
     * @param userDto user to update
     * @return the updated user and appropriate HTTP response
     */
    @ResponseBody
    @PutMapping(value = "${application.api.users.endpoint}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        UserDto result = userService.updateUser(userDto);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * Return the user with a given firstname
     * @param firstname the username
     * @return the corresponding user
     */
    @ResponseBody
    @GetMapping(value = "${application.api.users.endpoint}/firstname/{firstname}")
    public ResponseEntity<List<UserDto>> getUserByFirstName(@PathVariable("firstname") String firstname) {
        List<UserDto> userDtos = userService.getUserByFirstName(firstname);
        if (userDtos == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    /**
     * Return the user with a given lastname
     * @param lastname the username
     * @return the corresponding user
     */
    @ResponseBody
    @GetMapping(value = "${application.api.users.endpoint}/lastname/{lastname}")
    public ResponseEntity<List<UserDto>> getUserByLastName(@PathVariable("lastname") String lastname) {
        List<UserDto> userDtos = userService.getUserByLastName(lastname);
        if (userDtos == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

}
