package com.example.model.registration;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
  private final String firstName;
  private final String lastName;
  private final String email;
  private final String password;


}
