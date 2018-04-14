package org.java.training.converter;

import org.java.training.domain.User;
import org.java.training.dto.UserDto;
import org.springframework.lang.NonNull;

import java.util.stream.Collectors;

/**
 * A utility class to convert a User bean to/from a User DTO
 * @author Solange U. Gasengayire
 */
public class UserConverter {

    /**
     * Convert a user DTO to a user Entity
     * @param userDto the dto to be converted
     * @return the corresponding entity
     */
    public static User convert(@NonNull UserDto userDto) {
        User user = new User(userDto.getUserId(),
                                userDto.getUserName(),
                                userDto.getFirstName(),
                                userDto.getLastName());
        user.setRoles(userDto
                        .getRoleDtos()
                        .stream()
                        .map(RoleConverter::convert)
                        .collect(Collectors.toList()));
        return user;
    }

    /**
     * Convert a user Entity to a user dto
     * @param user the entity to be converted
     * @return the corresponding dto
     */
    public static UserDto convert(@NonNull User user) {
        UserDto userDto = new UserDto(user.getUserId(),
                                        user.getUserName(),
                                        user.getFirstName(),
                                        user.getLastName(),
                              null);
        userDto.setRoleDtos(user
                                .getRoles()
                                .stream()
                                .map(RoleConverter::convert)
                                .collect(Collectors.toList()));
        return userDto;
    }
}
