// ----------------
// --- 31217846 ---
// ----------------

package de.loop.mh.webengineering.controller;

import de.loop.mh.webengineering.logic.PostService;
import de.loop.mh.webengineering.logic.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

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

    @RequestMapping("/post")
    public List<String> post()
    {
        return post.getPostsAsStrings();
    }

    @RequestMapping("/post/{id}")
    public String post(@PathVariable("id") int id)
    {
        Post p = post.getPostById(id);

        if(p == null)
            return "";
        else
            return p.toString();
    }

    @RequestMapping(value = "/post/add", method=RequestMethod.GET)
    public void addPost(@RequestParam("title") String title)
    {
        post.addPost(title);
    }

    @RequestMapping(value = "/post/delete", method=RequestMethod.GET)
    public void addPost(@RequestParam("id") int id)
    {
        post.deletePost(id);
    }
}
