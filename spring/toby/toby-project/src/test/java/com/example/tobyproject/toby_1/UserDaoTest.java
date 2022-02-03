package com.example.tobyproject.toby_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class UserDaoTest {

//    @Test
//    void test() {
//        final UserDao dao = new DaoFactory().userDao();
//    }

    @Test
    void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        final UserDao dao = context.getBean("userDao", UserDao.class);
        final UserDao dao2 = context.getBean("userDao", UserDao.class);
        System.out.println("dao = " + dao);
        System.out.println("dao2 = " + dao2);
    }
}
