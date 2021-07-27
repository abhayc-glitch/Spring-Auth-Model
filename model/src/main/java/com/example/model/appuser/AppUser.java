package com.example.model.appuser;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AppUser implements UserDetails {

  @Id
  @SequenceGenerator(
    name = "student_sequence",
    sequenceName = "student_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "student_sequence"
  )

  private Long id;
  private String name;
  private String username;
  private String email;
  private String password;
  //ROle
  @Enumerated(EnumType.STRING)
  private AppUserRole appUserRole;
  // Is it a locked account
  private Boolean locked;
  // has the account been activated
  private Boolean enabled;

  public AppUser(String name,
                 String username,
                 String email,
                 String password,
                 AppUserRole appUserRole,
                 Boolean locked,
                 Boolean enabled) {
    this.name = name;
    this.username = username;
    this.email = email;
    this.password = password;
    this.appUserRole = appUserRole;
    this.locked = locked;
    this.enabled = enabled;
  }
  // This assign the user a
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
    return Collections.singletonList(authority);
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return !locked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }
}
