package com.security.inmemory.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasAuthority;

@RestController
@RequestMapping("/private")
public class PrivateController {

    @GetMapping
    public String hello(){
        return "Hello from private endpoint";

    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String helloToUser(){
        return "Hello from private endpoint for users";

    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String helloToAdmin(){
        return "Hello from private endpoint for admin";

    }
}
