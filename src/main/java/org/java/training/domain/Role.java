package org.java.training.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Bean class that represents the role given to a user
 * @author Solange U. Gasengayire
 */
@Entity
@Table(name = "roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleId")
    private Long roleId;

    @Column(name = "roleName")
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    /**
     * Default constructor
     */
    public Role() {
        super();
    }

    public Role(String name) {
        this.roleName = name;
    }

    /**
     * Return this entity's ID
     * @return roleId
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * Set this role's id
     * @param id the id to be set
     */
    public void setRoleId(Long id) {
        this.roleId = id;
    }

    /**
     * Return this role given name
     * @return roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Set this role's name
     * @param name the name to be set
     */
    public void setRoleName(String name) {
        this.roleName = name;
    }

    /**
     * Return a list of users with this role
     * @return users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Set this role's user list
     * @param userList the user list to be set
     */
    public void setUsers(List<User> userList) {
        this.users = userList;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return String.format("User [roleId=%s, roleName=%s]", roleId, roleName);
    }
}
