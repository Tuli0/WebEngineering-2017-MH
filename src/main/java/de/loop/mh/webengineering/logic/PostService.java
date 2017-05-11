// ----------------
// --- 31217846 ---
// ----------------

package de.loop.mh.webengineering.logic;

import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

@Service
public class PostService
{
    // --------------------
    // --- private vars ---
    // --------------------

    LinkedList<Post> posts = new LinkedList<Post>();


    // ---------------
    // --- Methods ---
    // ---------------

    /**
     * Returns a list containing all posts
     *
     * @return post list
     */
    public List<Post> getPosts()
    {
        return this.posts;
    }


    /**
     * Returns a list containing all posts as strings
     *
     * @return post list as list of strings
     */
    public List<String> getPostsAsStrings()
    {
        List<String> stringList = new LinkedList<String>();

        for (Post p : this.getPosts())
        {
            if(p == null)
                continue;

            stringList.add(p.toString());
        }

        return stringList;
    }

    /**
     * Retrieve a single post by looking for its id
     *
     * @param id The post's id you want to retrieve
     * @return single post with specified id
     */
    public Post getPostById(int id)
    {
        for(Post p : this.getPosts())
        {
            if(p == null)
                continue;

            if(p.getID() == id)
                return p;
        }

        return null;
    }

    /**
     * Add a new post
     *
     * @param newPost the new post
     */
    public void add(Post newPost)
    {
        this.posts.add(newPost);
    }

    /**
     * Delete a post
     *
     * @param id the post's id
     */
    public void deletePost(int id)
    {
        Post theOne = this.getPostById(id);

        if(theOne != null)
        {
            this.posts.remove(theOne);
        }
    }
}

