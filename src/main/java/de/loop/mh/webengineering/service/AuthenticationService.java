package de.loop.mh.webengineering.service;

import de.loop.mh.webengineering.logic.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserService userService;

    @Value("${authenticationService.jwt.secret}")
    private String JWTSecret;

    @Value("${authenticationService.salt}")
    private String salt;

    /**
     * Return object containing a valid user and his corresponding JWT token.
     */
    public static class UserToken {
        public User user;
        public String token;
    }


    /**
     * Create a JWT token and additional user information if the user's credentails are valid.
     *
     * @param email    email
     * @param password password
     * @return a UserToken or null if the credentials are not valid
     */
    public UserToken login(String email, String password) {
        String hashedPassword = hashPassword(password);
        User user = userService.getUser(email, hashedPassword);
        if (user == null) {
            return null;
        }

        String token = Jwts.builder()
                .setSubject(email)
                .setId(user.getId().toString())
                .signWith(SignatureAlgorithm.HS512, JWTSecret)
                .compact();

        UserToken userToken = new UserToken();
        userToken.user = user;
        userToken.token = token;
        return userToken;
    }


    /**
     * Validate that a token is valid and returns its body.
     *
     * Throws a SignatureException if the token is not valid.
     * @param jwtToken JWT token
     * @return JWT body
     */
    public Object parseToken(String jwtToken) {
        return Jwts.parser()
                .setSigningKey(JWTSecret)
                .parse(jwtToken)
                .getBody();
    }




    /**
     * Return (salt + password) hashed with SHA-512.
     *
     * The salt is configured in the property authenticationService.salt.
     *
     * @param password plain text password
     * @return hashed password
     */
    private String hashPassword(String password) {
        return DigestUtils.sha512Hex(salt + password);
    }
}
