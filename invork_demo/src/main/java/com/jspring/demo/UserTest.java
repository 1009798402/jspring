package com.jspring.demo;

import com.jspring.demo.controller.UserController;
import com.jspring.demo.service.UserService;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Test;

/**
 * @author jianchun.chen
 * @date 2020/6/16 14:20
 * @description：
 */
public class UserTest {

  @Test
  public void test() throws Exception {

    //1.获取要自动装配的类的class文件
    UserController userController = new UserController();
    Class<? extends UserController> clazz = userController.getClass();
    //2.创建userService
    UserService userService = new UserService();
    System.out.println(userService);
    //3.通过class文件 获取里面的set方法
    //3.1 获取要注入的变量名
    Field service = clazz.getDeclaredField("userService");
    String name = service.getName();
    //3.2 字符串拼接的方式获取他的set方法
    String setMethodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
    Method method = clazz.getMethod(setMethodName, UserService.class);
    //4.反射方式注入进去
    method.invoke(userController, userService);

    System.out.println(userController.getUserService());
  }
}
