// ----------------
// --- 31217846 ---
// ----------------

package de.loop.mh.webengineering.service;

import de.loop.mh.webengineering.logic.Post;
import de.loop.mh.webengineering.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService
{
    // --------------------
    // --- private vars ---
    // --------------------

    @Autowired
    private PostRepository repo;

    // ---------------
    // --- Methods ---
    // ---------------

    /**
     * Returns a list containing all posts
     *
     * @return post list
     */
    public Iterable<Post> getPosts()
    {
        return repo.findAll();
    }

    /**
     * Retrieve a single post by looking for its id
     *
     * @param id The post's id you want to retrieve
     * @return single post with specified id
     */
    public Post getPost(Long id)
    {
        return repo.findOne(id);
    }

    /**
     * Add a new post
     *
     * @param newPost the new post
     */
    public void add(Post newPost)
    {
        repo.save(newPost);
    }

    /**
     * Delete a post
     *
     * @param id the post's id
     */
    public void deletePost(Long id)
    {
        Post theOne = this.getPost(id);

        if(theOne != null)
        {
            repo.delete(theOne);
        }
    }
}

