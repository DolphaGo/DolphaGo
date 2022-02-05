package com.example.tobyproject.toby_1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // ApplicationContext 또는 빈 팩토리가 사용할 설정 정보라는 표시
public class CountingDaoFactory {

    @Bean // Object 생성을 담당하는 IoC용 메서드라는 표시
    public UserDao userDao() {
        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new CountingConnectionMaker(realConnectionMaker());
    }

    @Bean
    public ConnectionMaker realConnectionMaker() {
        return new DConnectionMaker();
    }
}
