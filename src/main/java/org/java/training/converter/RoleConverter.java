package org.java.training.converter;

import org.java.training.domain.Role;
import org.java.training.dto.RoleDto;
import org.springframework.lang.NonNull;

/**
 * A utility class to convert a Role bean to/from a Role DTO
 * @author Solange U. Gasengayire
 */
public class RoleConverter {

    /**
     * Convert a role DTO to a role Entity
     * @param roleDto dto to be converted
     * @return the corresponding entity
     */
    public static Role convert(@NonNull RoleDto roleDto) {
        Role role = new Role(roleDto.getRoleName());
        role.setRoleId(roleDto.getRoleId());
        return role;
    }

    /**
     * Convert a role Entity to a role DTO
     * @param role entity to be converted
     * @return the corresponding dto
     */
    public static RoleDto convert(@NonNull Role role) {
        return new RoleDto(role.getRoleId(), role.getRoleName());
    }
}
