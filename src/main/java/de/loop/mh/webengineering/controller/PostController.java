// ----------------
// --- 31217846 ---
// ----------------

package de.loop.mh.webengineering.controller;

import de.loop.mh.webengineering.logic.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
public class PostController {

    // --------------------
    // --- private vars ---
    // --------------------

    @Autowired
    Post post = new Post();


    // ---------------
    // --- methods ---
    // ---------------

    @RequestMapping("/post")
    public List<String> post()
    {
        return post.getPosts();
    }

    @RequestMapping("/post/add")
    public void addPost(@RequestParam("title") String title)
    {
        post.addPost(title);
    }
}
