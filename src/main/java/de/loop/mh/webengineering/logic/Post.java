// ----------------
// --- 31217846 ---
// ----------------

package de.loop.mh.webengineering.logic;

import java.util.Date;

public class Post {

    // ---------------
    // ---- static ---
    // ---------------

    private static int globalIDCounter = 1;

    public static Post create(String newTitle)
    {
        if(newTitle.length() < 1)
            return null;

        Post p = new Post(newTitle);

        p.setID(Post.globalIDCounter++);

        return p;
    }


    // --------------------
    // --- private vars ---
    // --------------------

    private int id_ = 0;
    private String title_;
    private Date timeStamp_;


    // -------------------------
    // --- Getter and Setter ---
    // -------------------------

    public void setID(int newID)
    {
        this.id_ = newID;
    }

    public int getID()
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

    private Post(String title)
    {
        this.setTitle(title);
        this.setTimeStamp(new Date());
    }


    // ---------------
    // --- Methods ---
    // ---------------

    @Override
    public String toString()
    {
        return "Post(" + this.getID() + ", " + this.getTitle() + ", " + this.timeStamp_.toString() + ")";
    }
}