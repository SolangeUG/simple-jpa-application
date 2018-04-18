package org.java.training.controller;

import org.java.training.dto.RoleDto;
import org.java.training.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Roles REST API controller
 * @author Solange U. Gasengayire
 */
@CrossOrigin
@RestController
@RequestMapping(value = "${application.api.path}",
                produces = {"application/json; charset=UTF-8"})
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * Return a list of all roles
     * @return roles list
     */
    @ResponseBody
    @GetMapping(value = "${application.api.roles.endpoint}")
    public ResponseEntity<List<RoleDto>> getAllRoles() {
        List<RoleDto> roleDtos = roleService.getAllRoles();
        if (roleDtos == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roleDtos, HttpStatus.OK);
    }
}
