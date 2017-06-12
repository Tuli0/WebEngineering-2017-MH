package de.loop.mh.webengineering.controller;

import de.loop.mh.webengineering.logic.Comment;
import de.loop.mh.webengineering.service.CommentService;
import de.loop.mh.webengineering.util.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    AddressService adressService;

    @RequestMapping(value = "/api/post/{postID}/comment/{commentID}", method = RequestMethod.GET)
    public Comment get(@PathVariable Long commentID) {
        return commentService.get(commentID);
    }

    @RequestMapping(value = "/api/post/{postID}/comment", method = RequestMethod.POST)
    public void create(@RequestBody Comment newComment) {
        commentService.add(newComment);
    }

    @RequestMapping(value = "/api/post/{postID}/comment/{commentID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long commentID) {
        commentService.delete(commentID);
    }

    @RequestMapping(value = "/api/post/{postID}/comment/{commentID}", method = RequestMethod.POST)
    public void update(@PathVariable Long commentID, @RequestBody Comment updatedComment) {
        commentService.update(commentID, updatedComment);
    }
}
