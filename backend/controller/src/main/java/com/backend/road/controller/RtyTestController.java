package com.backend.road.controller;

import com.backend.road.service.RtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/rty")
public class RtyTestController {

    RtyService rtyService;
    //@Autowired
    //UserService userService;



    @GetMapping("/createTestUser")
    public String createTestUser() {
        return null;
    }

    @GetMapping("/user")
    @ResponseBody
    public Principal user(Principal user) {
        return user;
    }
}
