package com.example.tobyproject.toby_1;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class CountingDaoFactoryTest {

    @Test
    void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        final UserDao dao = context.getBean("userDao", UserDao.class);

        /**
         * dao 사용 코드
         */
        dao.hello();

        final CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Connection counter : "+ ccm.getCounter());
    }
}
