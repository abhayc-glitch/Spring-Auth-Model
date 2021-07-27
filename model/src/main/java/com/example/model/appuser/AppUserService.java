package com.example.model.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
// This is a servie that ahs methods for obtaining User Details

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
  // Here we are loading the username and we are finding a user with it.
  // We are gonna query our database
  private final static String USER_NOT_FOUND_MSG = "user with email %s is not found";
  private final AppUserRepository appUserRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return appUserRepository.findByEmail(email)
      .orElseThrow(() ->
        new UsernameNotFoundException(
          String.format(USER_NOT_FOUND_MSG)));
  }
}
