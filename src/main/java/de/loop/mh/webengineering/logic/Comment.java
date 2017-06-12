package de.loop.mh.webengineering.logic;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {


    // --------------------
    // --- private vars ---
    // --------------------

    @Id
    @GeneratedValue
    private long id_;

    @ManyToOne(optional = false)
    private User creator_;

    @Column(nullable = false, name="comment_")
    private String comment_;

    private Date timestamp_;


    // -------------------------
    // --- getter and setter ---
    // -------------------------

    public long getID() {
        return this.id_;
    }

    public void setID(long newID) {
        this.id_ = newID;
    }

    public User getCreator() {
        return this.creator_;
    }

    public void setCreator(User newCreator) {
        this.creator_ = newCreator;
    }

    public String getComment() {
        return this.comment_;
    }

    public void setComment(String newComment) {
        this.comment_ = newComment;
    }

    public Date getTimestamp() {
        return this.timestamp_;
    }

    public void setTimestamp(Date newTimestamp) {
        this.timestamp_ = newTimestamp;
    }


    // ---------------
    // --- methods ---
    // ---------------

    @Override
    public String toString() {
        return "";
    }
}
