package org.java.training.controller;

import org.java.training.dto.UserDto;
import org.java.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API controller
 * @author Solange U. Gasengayire
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Return the user with a given id
     * @param id the user id
     * @return the corresponding user
     */
    @GetMapping(value = "/getUser/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = userService.getUserById(id);
        if (userDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    /**
     * Return a list of all users
     * @return users list
     */
    @GetMapping(value = "/getAllUsers")
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
     */
    @PostMapping(value = "/saveUser")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        UserDto result = userService.saveUser(userDto);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
