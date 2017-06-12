package de.loop.mh.webengineering.service;

import de.loop.mh.webengineering.logic.User;
import de.loop.mh.webengineering.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Long ANONYMOUS_USER_ID = -1L;

    // --------------------
    // --- private vars ---
    // --------------------

    @Autowired
    private UserRepository userRepository;


    // -------------------
    // --- Constructor ---
    // -------------------

    public UserService() {
        this.loginAnonymous();
    }


    // -------------------------
    // --- Getter and Setter ---
    // -------------------------

    /**
     * Sets the currently logged in user.
     *
     * @param userID The to-be-logged-in user's id
     * @param email The to-be-logged-in user's email address.
     */
    public void login(Long userID, String email) {
        User user = new User(email, "");
        user.setId(userID);
        UsernamePasswordAuthenticationToken secAuth = new UsernamePasswordAuthenticationToken(user, null);
        SecurityContextHolder.getContext().setAuthentication(secAuth);
    }

    /**
     * Retrieves a user obj by looking for a matching compination of email and password.
     *
     * @param email The to-be-fetched user's email address.
     * @param password The to-be-fetched user's password.
     *
     * @return Returns a user obj matching the input parameters.
     */
    public User getUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    /**
     * Returns the currently logged in user.
     *
     * @return Returns the logged in user.
     */
    public User getLoggedInUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public void loginAnonymous() {
        this.login(UserService.ANONYMOUS_USER_ID, "anon@ymo.us");
    }

    /**
     * Checks if any user is logged in
     *
     * @return true if no user is logged in. false else.
     */
    public Boolean isAnonymous() {
        return this.getLoggedInUser().getId() == UserService.ANONYMOUS_USER_ID;
    }

    /**
     *
     * @param u Checks if u is a real, valid user
     * @return true if u is valid. false else.
     */
    public Boolean isAnonymous(User u) {
        if(u == null) {
            return this.isAnonymous();
        }

        return u.getId() == UserService.ANONYMOUS_USER_ID;
    }
}
