package com.solidtech.zuulapigatewayserver.controller;

import com.solidtech.zuulapigatewayserver.model.AuthToken;
import com.solidtech.zuulapigatewayserver.model.LoginUser;
import com.solidtech.zuulapigatewayserver.model.User;
import com.solidtech.zuulapigatewayserver.model.UserDto;
import com.solidtech.zuulapigatewayserver.security.TokenProvider;
import com.solidtech.zuulapigatewayserver.service.UserService;
import com.solidtech.zuulapigatewayserver.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {


    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;

    // @Autowired
    // private UserServiceImpl userService;

    @GetMapping(value = "/users/testUri", produces = "application/json")
    public ResponseEntity testGet(){
        log.info("Ok TEST");
        return ok("OK TEST");
    }


    @PostMapping("/users/signin")
    public ResponseEntity<?> signIn(@RequestBody LoginUser loginUser) throws AuthenticationException {

        try {
            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginUser.getUsername(),
                            loginUser.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String token = jwtTokenUtil.generateToken(authentication);
            return ResponseEntity.ok(new AuthToken(token));
        } catch (AuthenticationException ae){
            throw new BadCredentialsException("Invalid username/password supplied");
        }

    }


    @RequestMapping(value="/users/register", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }

    @PostMapping("/signout")
    @ResponseBody
    public ResponseEntity<AuthToken> logout (@RequestHeader(value="Authorization") String token) {
        HttpHeaders headers = new HttpHeaders();
        if (userService.logout(token)) {
            headers.remove("Authorization");
            return new ResponseEntity<AuthToken>(new AuthToken("logged out"), headers, HttpStatus.CREATED);
        }
        return new ResponseEntity<AuthToken>(new AuthToken("Logout Failed"), headers, HttpStatus.NOT_MODIFIED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/users/adminping", method = RequestMethod.GET)
    public String adminPing(){
        return "Only Admins Can Read This";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value="/users/userping", method = RequestMethod.GET)
    public String userPing(){
        return "Any User Can Read This";
    }

}
