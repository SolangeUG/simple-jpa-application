package org.java.training.user;

import javax.persistence.*;

/**
 * Bean class that represents a user.
 * @author Solange U. Gasengayire
 */
@Entity
@NamedQuery(
        query="SELECT u FROM User u",
        name = "query_find_all_users"
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String role;

    /**
     * No-argument constructor
     * Required by JPA
     */
    protected User(){
        super();
    }

    /**
     * Constructor
     * @param name the user's name
     * @param role the user's role
     */
    public User(String name, String role) {
        super();
        this.name = name;
        this.role = role;
    }

    /**
     * Return this entity's ID
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Return this user's name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Return this user's role
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Return the string representation of this bean
     * @return this user as a string
     */
    @Override
    public String toString() {
        return String.format("User [id=%s, name=%s, role=%s]", id, name, role);
    }
}
