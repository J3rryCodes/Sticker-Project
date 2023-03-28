package de.ij3rry.stickerproject.service.impl;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class UserService implements ReactiveUserDetailsService {

    private final static List<UserDetails> USERS = Arrays.asList(new User("jerin@gmail.com", "password", Collections.singleton(new SimpleGrantedAuthority("USER"))));

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return Mono.just(USERS.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElseThrow(()-> new UsernameNotFoundException("User not found")));
    }
}
