package org.java.training.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Bean class that represents a user.
 * @author Solange U. Gasengayire
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column
    private String userName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Role> roles;

    /**
     * No-argument constructor
     * Required by JPA
     */
    protected User(){
        super();
    }

    /**
     * Constructor
     * @param userName the user's name
     */
    public User(String userName) {
        super();
        this.userName = userName;
    }

    /**
     * Return this entity's ID
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Set this user's id
     * @param id the id to be set
     */
    public void setUserId(Long id) {
        this.userId = id;
    }

    /**
     * Return this user's name
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set this user's name
     * @param name the name to be set
     */
    public void setUserName(String name) {
        this.userName = name;
    }

    /**
     * Return this user's roles
     * @return the roles
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * Set this user's roles
     * @param roleList the roles to be set
     */
    public void setRoles(List<Role> roleList) {
        this.roles = roleList;
    }

    /**
     * Return the string representation of this bean
     * @return this user as a string
     */
    @Override
    public String toString() {
        return String.format("User [userId=%s, userName=%s]", userId, userName);
    }
}
