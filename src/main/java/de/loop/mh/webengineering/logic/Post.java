package de.loop.mh.webengineering.logic;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class Post
{
    // --------------------
    // --- private vars ---
    // --------------------

    LinkedList<String> posts = new LinkedList<String>();


    // ---------------
    // --- Methods ---
    // ---------------

    /**
     * Returns a list containing all posts
     *
     * @return post list
     */
    public List<String> getPosts()
    {
        return this.posts;
        //new Date().toString();
    }


    /**
     * Add a new post
     *
     * @param title the new post's title
     */
    public void addPost(String title)
    {
        this.posts.add(title);
    }
}
