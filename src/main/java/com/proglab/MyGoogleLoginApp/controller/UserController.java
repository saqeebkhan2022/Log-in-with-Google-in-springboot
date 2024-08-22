package com.proglab.MyGoogleLoginApp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/user")
    public Principal  welcome(Principal principal){
        return principal;
    }
@GetMapping("/")
public String user(Principal principal) {
    Authentication authentication = (Authentication) principal;
    DefaultOAuth2User oAuth2User = (DefaultOAuth2User) authentication.getPrincipal();
    String username = oAuth2User.getAttribute("name");
    Object email = oAuth2User.getAttribute("email");
    Object picture = oAuth2User.getAttribute("picture");
    return "Hello, " + username + " (" + email + ")" + "<br>" +
            "Profile Picture: <img src='" + picture + "' alt='Profile Picture'>";
}
}
