package com.endava.pages;

import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {




    public void connectToDB(String query) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mariadb://192.168.164.15:3306/bitnami_opencart", "root", "root");
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
        connection.close();
    }
}
