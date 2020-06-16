package com.jspring.demo;

import com.jspring.demo.controller.UserController;
import org.junit.Test;

import java.util.stream.Stream;

public class UserTest2 {

    @Test
    public void test(){

        UserController userController = new UserController();

        Class<? extends UserController> clazz = userController.getClass();

        Stream.of( clazz.getFields()).forEach(field -> {

            //获取注解
            Autozp annotation = field.getAnnotation(Autozp.class);

            if (annotation!=null){

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
