package com.example.tobyproject.toby_1;

import java.sql.Connection;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        System.out.println("D사 커넥션.......");
        // D사 커넥션
        return null;
    }
}
