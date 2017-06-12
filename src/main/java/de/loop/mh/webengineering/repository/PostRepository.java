// ----------------
// --- 31217846 ---
// ----------------

package de.loop.mh.webengineering.repository;

import de.loop.mh.webengineering.logic.Post;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    /*
    @Query("SELECT p FROM Post p ORDER BY p.createdAt DESC")
    List<Post> findAll();
    */
}