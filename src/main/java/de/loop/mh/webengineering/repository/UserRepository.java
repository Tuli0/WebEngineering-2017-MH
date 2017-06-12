package de.loop.mh.webengineering.repository;

import de.loop.mh.webengineering.logic.Post;
import de.loop.mh.webengineering.logic.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<Post, Long> {

    @Query("SELECT u FROM User_ u WHERE u.email_ = :email")
    User findByEmail(@Param("email") String email);

    @Query("SELECT u from User_ u WHERE u.email_ = :email AND u.password_ = :password")
    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
