package de.loop.mh.webengineering.service;

import de.loop.mh.webengineering.logic.Comment;
import de.loop.mh.webengineering.logic.User;
import de.loop.mh.webengineering.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserService userService;


    /**
     * Retrieve a single comment by looking for its id
     *
     * @param commentID The comment's id you want to retrieve
     * @return single post with specified id
     */
    public Comment get(Long commentID) {
        return commentRepository.findOne(commentID);
    }


    /**
     * Add a new comment
     *
     * @param newComment the new comment
     */
    public void add(Comment newComment)
    {
        commentRepository.save(newComment);
    }


    /**
     * Delete a comment
     *
     * @param commentID the comment's id
     */
    public void delete(Long commentID)
    {
        Comment theOne = this.get(commentID);
        User loggedInOne = userService.getLoggedInUser();

        if(theOne != null)
        {
            if(loggedInOne == theOne.getCreator()) {
                commentRepository.delete(theOne);
            } else {
                throw new IllegalStateException("Access violation :: Only this comment's creator can delete this comment.");
            }
        }
    }


    /**
     * Update a comment
     *
     * @param commentID The to-be-updated comment's id
     * @param updatedComment Comment obj representing the updated version
     */
    public void update(Long commentID, Comment updatedComment) {
        Comment comment = commentRepository.findOne(commentID);

        if (comment.getCreator() == userService.getLoggedInUser()) {
            comment.setComment(updatedComment.getComment());
            commentRepository.save(comment);
        } else {
            throw new IllegalStateException("Access violation :: This user does not have the right to alter comments of other users.");
        }
    }
}
