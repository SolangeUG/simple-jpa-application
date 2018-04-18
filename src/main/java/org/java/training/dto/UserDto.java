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
    private String firstName;
    private String lastName;
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
    private UserDto(Long id, String name, List<RoleDto> roleDtoList) {
        this.userId = id;
        this.userName = name;
        this.roleDtos = roleDtoList;
    }

    /**
     * Constructor
     * @param name username
     * @param firstName this dto's firstname
     * @param lastName this dto's lastname
     */
    private UserDto(String name, String firstName, String lastName) {
        this.userName = name;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Constructor
     * @param id this dto's id
     * @param name this dto's user name
     * @param firstName this dto's first name
     * @param lastName this dto's last name
     * @param roleDtoList this dto's list of role dtos
     */
    public UserDto(Long id, String name, String firstName, String lastName, List<RoleDto> roleDtoList) {
        this(id, name, roleDtoList);
        this.firstName = firstName;
        this.lastName = lastName;
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
     * Return this dto's first name
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set this dto's first name
     * @param firstName the name to be set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Return this dto's last name
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set this dto's last name
     * @param lastName the name to be set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
