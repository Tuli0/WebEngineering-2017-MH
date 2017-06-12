// ----------------
// --- 31217846 ---
// ----------------

package de.loop.mh.webengineering.controller;

import de.loop.mh.webengineering.service.PostService;
import de.loop.mh.webengineering.logic.Post;

import de.loop.mh.webengineering.service.UserService;
import de.loop.mh.webengineering.util.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    // --------------
    // --- struct ---
    // --------------

    public class PostCreated {
         public String url;
    }


    // --------------------
    // --- private vars ---
    // --------------------

    @Autowired
    PostService postService = new PostService();

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

    // ---------------
    // --- methods ---
    // ---------------

    @RequestMapping(value = "/api/post", method = RequestMethod.GET)
    public Iterable<Post> post()
    {
        return postService.getPosts();
    }

    @RequestMapping(value = "/api/post/{id}", method = RequestMethod.GET)
    public Post post(@PathVariable("id") Long id)
    {
        Post p = postService.getPost(id);


        return p;
    }

    @RequestMapping(value = "/api/post", method=RequestMethod.POST)
    public ResponseEntity<Object> addPost(@RequestBody Post newPost)
    {
        if(userService.isAnonymous())
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        newPost.setCreator(userService.getLoggedInUser());
        postService.add(newPost);

        PostCreated postCreationWitness = new PostCreated();
        postCreationWitness.url = addressService.getServerURL() + "/api/post/" + newPost.getID();
        return ResponseEntity.ok(postCreationWitness);
    }

    @RequestMapping(value = "/api/post/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> addPost(@PathVariable("id") Long id)
    {
        if(userService.isAnonymous())
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        postService.deletePost(id);

        return ResponseEntity.ok(id);
    }
}
