package org.java.training.dto;

import java.util.List;

/**
 * User Data Transfer Object
 * used to transfer user data through the client
 * @author Solange U. Gasengayire
 */
public class UserDto {

    private Long userId;
    private String userName;
    private List<RoleDto> roleDtos;

    /**
     * Default constructor
     */
    public UserDto() {
        super();
    }

    /**
     * Constructor
     * @param id this dto's id
     * @param name this dto's name
     * @param roleDtoList this dto's list of role dtos
     */
    public UserDto(Long id, String name, List<RoleDto> roleDtoList) {
        this.userId = id;
        this.userName = name;
        this.roleDtos = roleDtoList;
    }

    /**
     * Return this dto's id
     * @return userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Set this dto's id
     * @param userId the id to be set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Return this dto's username
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set this dto's username
     * @param userName the name to be set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Return this dto's list of role dtos
     * @return the role dtos
     */
    public List<RoleDto> getRoleDtos() {
        return roleDtos;
    }

    /**
     * Set this dto's list of role dtos
     * @param roleDtos the role dtos to be set
     */
    public void setRoleDtos(List<RoleDto> roleDtos) {
        this.roleDtos = roleDtos;
    }
}
