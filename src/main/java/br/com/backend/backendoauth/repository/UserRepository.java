package br.com.backend.backendoauth.repository;

import br.com.backend.backendoauth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 2019-05-27
 Time: 11:28
 To change this template use File | Settings | File Templates.
*/
public interface UserRepository extends JpaRepository<User, Long> {

  User findByEmail(String email);
}
