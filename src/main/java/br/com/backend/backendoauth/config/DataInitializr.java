package br.com.backend.backendoauth.config;
/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 2019-05-27
 Time: 11:31
 To change this template use File | Settings | File Templates.
*/

import br.com.backend.backendoauth.model.Role;
import br.com.backend.backendoauth.model.User;
import br.com.backend.backendoauth.repository.RoleRepository;
import br.com.backend.backendoauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

    List<User> users = userRepository.findAll();

    if (users.isEmpty()) {
      createUser("Admin", "admin" ,passwordEncoder.encode("123456"), Const.ROLE_ADMIN);
      createUser("Cliente", "cliente" ,passwordEncoder.encode("123456"), Const.ROLE_CLIENT);
    }
  }

  public void createUser(String name, String email, String password, String roleName) {

    Role role = new Role(roleName);

    this.roleRepository.save(role);
    User user = new User(name, email, password, Arrays.asList(role));
    userRepository.save(user);
  }
}
