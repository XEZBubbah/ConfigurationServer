package com.config.configurationserver.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BuscadorUsuario implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(!"admin".equals(username)) {
            throw new UsernameNotFoundException("El usuario no existe");
        }
        return User.builder()
                .username(username)
                .password(encoder().encode("root"))
                .roles()
                .build();
    }

    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
