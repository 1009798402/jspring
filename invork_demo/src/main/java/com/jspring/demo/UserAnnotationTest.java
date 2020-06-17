package com.jspring.demo;

import com.jspring.demo.controller.UserController;
import java.lang.reflect.Field;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @author jianchun.chen
 * @date 2020/6/16 14:20
 * @description：
 */
public class UserAnnotationTest {


  @Test
  public void test() {

    //1.获取controller的class文件
    UserController userController = new UserController();
    Class<? extends UserController> clazz = userController.getClass();

    //2.获取所有的属性
    Field[] fields = clazz.getDeclaredFields();
    Stream.of(fields).forEach(field->{
      if (field.getAnnotation(JAutowired.class)!=null){
        field.setAccessible(true);
        Class<?> type = field.getType();
        try {
          Object o = type.newInstance();
          field.set(userController,o);
        } catch (InstantiationException | IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    });

    System.out.println(userController.getUserService());

  }
}
