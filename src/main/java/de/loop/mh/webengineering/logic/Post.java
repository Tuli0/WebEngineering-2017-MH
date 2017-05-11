// ----------------
// --- 31217846 ---
// ----------------

package de.loop.mh.webengineering.logic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class Post {

    // --------------------
    // --- private vars ---
    // --------------------

    @Id
    @GeneratedValue
    private long id_ = 0;
    private String title_;
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