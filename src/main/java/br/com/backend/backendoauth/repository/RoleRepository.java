package br.com.backend.backendoauth.repository;

import br.com.backend.backendoauth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 2019-05-27
 Time: 11:27
 To change this template use File | Settings | File Templates.
*/
public interface RoleRepository extends JpaRepository<Role, Long> {

  Role findByName(String name);
}
