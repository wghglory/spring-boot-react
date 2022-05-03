package com.guanghui.springbootreact.security;

import com.guanghui.springbootreact.entity.User;
import com.guanghui.springbootreact.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Used for Basic Authentication
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
//    Basic authentication, after get the user, compare password.
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        org.springframework.security.core.userdetails.User.UserBuilder builder;

        if (user.isPresent()) {
            User currentUserFromDb = user.get();

            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(currentUserFromDb.getPassword());
            builder.roles(currentUserFromDb.getRole());
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return builder.build();
    }
}
