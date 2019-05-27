package br.com.backend.backendoauth.service;
/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 2019-05-27
 Time: 11:40
 To change this template use File | Settings | File Templates.
*/

import br.com.backend.backendoauth.model.User;
import br.com.backend.backendoauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MyUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Autowired
  public MyUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(email);

    if (user == null) {
      throw new UsernameNotFoundException(String.format("Usuário não existe!", email));
    }

    return new UserRepositoryUserDetails(user);
  }


  private final static class UserRepositoryUserDetails extends User implements UserDetails {

    private static final long serialVersionUID = 1L;

    public UserRepositoryUserDetails(User user) {
      super(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return getRoles();
    }

    @Override
    public String getUsername() {
      return this.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
      return true;
    }

    @Override
    public boolean isAccountNonLocked() {
      return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
      return true;
    }

    @Override
    public boolean isEnabled() {
      return true;
    }

    @Override
    public String getPassword() {
      return super.getPassword();
    }

  }

}
