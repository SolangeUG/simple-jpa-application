package org.java.training.service;

import org.java.training.converter.RoleConverter;
import org.java.training.converter.UserConverter;
import org.java.training.domain.Role;
import org.java.training.dto.RoleDto;
import org.java.training.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Role service implementation
 * @author Solange U. Gasengayire
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    /**
     * Find a role by their id
     *
     * @param id role id
     * @return the corresponding role
     */
    @Override
    public RoleDto getRoleById(Long id) {
        Role role = repository.getOne(id);
        return RoleConverter.convert(role);
    }

    /**
     * Find all roles
     *
     * @return a list of all roles
     */
    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> roles = repository.findAll();
        return roles
                .stream()
                .map(RoleConverter::convert)
                .collect(Collectors.toList());
    }
}
