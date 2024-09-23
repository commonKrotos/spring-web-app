package com.backend.road.service.security;

import com.backend.road.model.Role;
import com.backend.road.model.User;
import com.backend.road.model.UserPrincipal;
import com.backend.road.repository.security.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService  {

//    @Autowired
//    private WebApplicationContext applicationContext;


    @Autowired
    private UserRepository userRepository;

//    @PostConstruct
//    public void completeSetup() {
//        userRepository = applicationContext.getBean(UserRepository.class);
//    }

    @Override
    public UserDetails loadUserByUsername(final String username) {
        final User appUser = userRepository.findByUsername(username);
        if (appUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(appUser);
    }

    public boolean saveUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(new BCryptPasswordEncoder(11)
                .encode(user.getPassword()));
        user.setName(user.getUsername());

        userRepository.save(user);
        return true;
    }
}
