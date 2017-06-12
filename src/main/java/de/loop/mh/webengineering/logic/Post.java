// ----------------
// --- 31217846 ---
// ----------------

package de.loop.mh.webengineering.logic;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.Date;

@Entity
public class Post {

    // --------------------
    // --- private vars ---
    // --------------------

    @Id
    @GeneratedValue
    @JsonIgnore
    private long id_;

    @ManyToOne(optional = false)
    private User creator_;

    @Column(nullable = false, name="title_")
    private String title_;

    @Column(nullable = false, name="createdAt_")
    private Date timeStamp_;

    // -------------------------
    // --- Getter and Setter ---
    // -------------------------

    public void setID(long newID)
    {
        this.id_ = newID;
    }

    public long getID()
    {
        return this.id_;
    }

    public void setTitle(String newTitle)
    {
        this.title_ = newTitle;
    }

    public String getTitle()
    {
        return this.title_;
    }

    public void setTimeStamp(Date newDate)
    {
        this.timeStamp_ = newDate;
    }

    public Date getTimeStamp()
    {
        return this.timeStamp_;
    }

    public void setCreator(User newCreator) {
        this.creator_ = newCreator;
    }

    public User getCreator() {
        return this.creator_;
    }

    // -------------------
    // --- Constructor ---
    // -------------------

    public Post()
    {
        this.setTimeStamp(new Date());
    }


    // ---------------
    // --- Methods ---
    // ---------------

    /*
    @Override
    public String toString()
    {
        return "Post(" + this.getID() + ", " + this.getTitle() + ", " + this.timeStamp_.toString() + ")";
    }
    */
}