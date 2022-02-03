package com.example.tobyproject.toby_1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDao {

    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
    }

}
