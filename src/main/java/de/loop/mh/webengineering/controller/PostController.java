// ----------------
// --- 31217846 ---
// ----------------

package de.loop.mh.webengineering.controller;

import de.loop.mh.webengineering.service.PostService;
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
    public Iterable<Post> post()
    {
        return post.getPosts();
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public Post post(@PathVariable("id") Long id)
    {
        Post p = post.getPost(id);

        return p;
    }

    @RequestMapping(value = "/post", method=RequestMethod.POST)
    public String addPost(@RequestBody Post newPost)
    {
        post.add(newPost);

        return "{\"url\" : \"/post/" + newPost.getID() + "\"}";
    }

    @RequestMapping(value = "/post/{id}", method=RequestMethod.DELETE)
    public void addPost(@PathVariable("id") Long id)
    {
        post.deletePost(id);
    }
}
