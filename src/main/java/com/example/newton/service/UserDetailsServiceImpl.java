package com.example.newton.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.newton.model.AppUser;
import com.example.newton.repository.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  // Class injection
  @Autowired
  AppUserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Optional<AppUser> user = repository.findByUsername(username);
    UserBuilder builder = null;
    if (user.isPresent()) {
      AppUser currentUser = user.get();
      builder = org.springframework.security.core.userdetails.User.withUsername(username);
      builder.password(currentUser.getPassword());
      builder.roles(currentUser.getRole());
    } else {
      throw new UsernameNotFoundException("User not found.");
    }
    return builder.build();
  }

}
