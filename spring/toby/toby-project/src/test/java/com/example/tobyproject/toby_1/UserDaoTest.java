package com.example.tobyproject.toby_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserDaoTest {

    @Test
    void test() {
        final UserDao dao = new DaoFactory().userDao();
    }
}
