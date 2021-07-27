package com.example.model.registration;

import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

  public String register(RegistrationRequest request) {
    return "The regestration works";
  }
}
