package br.com.backend.backendoauth.model;

/*
 Created by IntelliJ IDEA.
 User:kelvin
 Date:2019-05-27
 Time:10:57
 To change this template use File|Settings|File Templates.
*/

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Role implements GrantedAuthority {

  public Role(String name) {
    this.name = name;
  }

  public Role() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  String name;

  @Override
  public String getAuthority() {
    return this.name;
  }
}
