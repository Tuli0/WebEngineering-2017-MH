// ----------------
// --- 31217846 ---
// ----------------

package de.loop.mh.webengineering.controller;

import de.loop.mh.webengineering.logic.PostService;
import de.loop.mh.webengineering.logic.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    // --------------------
    // --- private vars ---
    // --------------------

    @Autowired
    PostService post = new PostService();


    // ---------------
    // --- methods ---
    // ---------------

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public List<Post> post()
    {
        return post.getPosts();
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public Post post(@PathVariable("id") int id)
    {
        Post p = post.getPostById(id);

        return p;
    }

    @RequestMapping(value = "/post", method=RequestMethod.POST)
    public void addPost(@RequestBody Post newPost)
    {
        post.add(newPost);
    }

    @RequestMapping(value = "/post/{id}", method=RequestMethod.DELETE)
    public void addPost(@PathVariable("id") int id)
    {
        post.deletePost(id);
    }
}
