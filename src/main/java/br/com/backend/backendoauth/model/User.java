package br.com.backend.backendoauth.model;
/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 2019-05-27
 Time: 11:18
 To change this template use File | Settings | File Templates.
*/

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @Column(unique = true)
  private String email;

  @JsonIgnore
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "user_role",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private List<Role> roles;

  public User() {
  }

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public User(User user) {
    super();
    this.name = user.getName();
    this.email = user.getEmail();
    this.password = user.getPassword();
    this.roles = user.getRoles();
    this.id = user.getId();
  }

  public User(String name, String email, String password, List<Role> roles) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.roles = roles;
  }
}
