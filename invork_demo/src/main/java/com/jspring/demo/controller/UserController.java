package com.jspring.demo.controller;

import com.jspring.demo.service.UserService;

/**
 * @author jianchun.chen
 * @date 2020/6/16 14:20
 * @description：
 */
public class UserController {

  private UserService userService;

  public UserService getUserService() {
    return userService;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
  }
}
