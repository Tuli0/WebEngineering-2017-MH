package de.loop.mh.webengineering.repository;

import de.loop.mh.webengineering.logic.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    //nothing for now
}
