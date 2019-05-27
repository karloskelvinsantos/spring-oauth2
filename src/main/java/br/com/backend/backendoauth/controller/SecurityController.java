package br.com.backend.backendoauth.controller;
/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 2019-05-27
 Time: 12:25
 To change this template use File | Settings | File Templates.
*/

import br.com.backend.backendoauth.config.Const;
import br.com.backend.backendoauth.model.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {

  @RequestMapping(value = "/user-auth", method = RequestMethod.GET)
  @ResponseBody
  @Secured({Const.ROLE_CLIENT, Const.ROLE_ADMIN})
  public User user() {
    return (User) SecurityContextHolder.getContext()
            .getAuthentication()
            .getPrincipal();
  }
}
