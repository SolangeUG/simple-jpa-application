package org.java.training.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Bean class that represents a user.
 * @author Solange U. Gasengayire
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private Long userId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
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
     * Constructor
     * @param userName user name
     * @param firstName user's first name
     * @param lastName user's last name
     */
    public User(String userName, String firstName, String lastName) {
        this(userName);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Constructor
     * @param id user ID
     * @param userName user name
     * @param firstName user's first name
     * @param lastName user's last name
     */
    public User(Long id, String userName, String firstName, String lastName) {
        this(userName, firstName, lastName);
        this.userId = id;
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
     * Return this user's first name
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set this user's first name
     * @param firstName the name to be set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Return this user's last name
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set this user's last name
     * @param lastName the name to be set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return String.format("User [userId=%s, userName=%s, firstName=%s, lastName=%s]",
                             userId, userName, firstName, lastName);
    }
}
