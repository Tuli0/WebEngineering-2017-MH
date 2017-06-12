package de.loop.mh.webengineering.logic;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


@Entity(name = "User_")
public class User {

    // --------------------
    // --- private vars ---
    // --------------------

    @Id
    @GeneratedValue
    private Long id_;

    private String email_;

    @JsonIgnore
    private String password_;


    // -------------------
    // --- Constructor ---
    // -------------------

    public User() {}

    public User(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }


    // -------------------------
    // --- Getter and Setter ---
    // -------------------------

    public void setId(Long newID) {
        this.id_ = newID;
    }

    public Long getId() {
        return this.id_;
    }

    public void setEmail(String newEmail) {
        this.email_ = newEmail;
    }

    public String getEmail() {
        return this.email_;
    }

    public void setPassword(String newPassword) {
        this.password_ = newPassword;
    }

    public String getPassword() {
        return this.password_;
    }


    // ---------------
    // --- Methods ---
    // ---------------
}
