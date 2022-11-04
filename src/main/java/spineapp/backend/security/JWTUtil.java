package spineapp.backend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

    @Component
    public class JWTUtil {

        @Value("${jwt_secret}")
        private String secret;

        /**
         * Generates a new JWT security token for the provided user
         * @param email Email address
         * @return
         * returns a newly generated JWT security token
         * @throws IllegalArgumentException
         * Throws an exception if the arguments given for the token generation do not conform to the expected type
         * @throws JWTCreationException
         * Throws an exception if the JWT token cannot be created for whatever reason (more details provided in error code)
         */
        public String generateToken(String email) throws IllegalArgumentException, JWTCreationException {
            return JWT.create()
                    .withSubject("User Details")
                    .withClaim("email", email)
                    .withIssuedAt(new Date())
                    .withIssuer("SPINE")
                    .sign(Algorithm.HMAC256(secret));
        }

        /**
         * Validates the given JWT token and retrieves the subject attached to the provided token
         * @param token the provided JWT token
         * @return
         * returns the email address of the token's subject
         * @throws JWTVerificationException
         * Throws an exception if the JWT token could not be verified for a reason provided with the error.
         */
        public String validateTokenAndRetrieveSubject(String token)throws JWTVerificationException {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                    .withSubject("User Details")
                    .withIssuer("SPINE")
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("email").asString();
        }
    }

