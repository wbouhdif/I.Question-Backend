package spineapp.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spineapp.backend.daos.AccountDAO;
import spineapp.backend.models.Account;
import spineapp.backend.models.LoginCredentials;
import spineapp.backend.security.JWTUtil;

import java.util.Collections;
import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JWTUtil jwtUtil;
    private final AuthenticationManager authManager;

    private final AccountDAO accountDAO;

    /**
     * Constructs instance of AuthController with the jwtUtil and authManager via dependency injection.
     * @param jwtUtil Parameter of type JWTUtil to be injected into.
     * @param authManager Parameter of type AuthenticationManager to be injected into.
     */
    @Autowired
    public AuthController(JWTUtil jwtUtil, AuthenticationManager authManager, AccountDAO accountDAO) {
        this.jwtUtil = jwtUtil;
        this.authManager = authManager;
        this.accountDAO = accountDAO;
    }

    /**
     * Handles all requests to the api/auth/login endpoint
     * @param body LoginCredentials, sent by the user, to be checked.
     * @return
     * Returns a JWT token which will be used to authenticate requests of the logged-in user.
     */
    @PostMapping("/login")
    public ResponseEntity<Object> loginHandler(@RequestBody LoginCredentials body) {
        try {
            UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());
            authManager.authenticate(authInputToken);

            String token = jwtUtil.generateToken(body.getEmail());
            Account account = accountDAO.findAccountByEmail(body.getEmail()).get();

            if (account.getAuthorised()) {

                HashMap<Object, Object> responseBody = new HashMap<>();
                responseBody.put("token", token);
                responseBody.put("account", account);

                return new ResponseEntity<>(responseBody, HttpStatus.ACCEPTED);

            } else {
                return new ResponseEntity<>(Collections.singletonMap("message", "Account not authorised"), HttpStatus.UNAUTHORIZED);
            }
        }catch (AuthenticationException authExc){
            return new ResponseEntity<>(Collections.singletonMap("message", "Invalid Login Credentials"), HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
