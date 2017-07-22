package com.krew.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.krew.entity.User;
import com.krew.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmailId(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        //for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority("user"));
        //}

        return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(), grantedAuthorities);
    }
}
