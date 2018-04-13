package org.java.training.dto;

/**
 * Role Data Transfer Object
 * used to transfer role data through the client
 * @author Solange U. Gasengayire
 */
public class RoleDto {

    private Long roleId;
    private String roleName;

    /**
     * Default constructor
     */
    public RoleDto() {
        super();
    }

    /**
     * Constructor
     * @param id this dto's id
     * @param name this dto's name
     */
    public RoleDto(Long id, String name) {
        this.roleId = id;
        this.roleName = name;
    }

    /**
     * Return this dto's id
     * @return the role dto id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * Set this dto's id
     * @param roleId the id to be set
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * Return this dto's name
     * @return the dto's role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Set this dto's role name
     * @param roleName the name to be set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
