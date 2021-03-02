package org.geektimes.test;

import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;

public class DerbyTest {
    public static void main(String[] args) throws Exception{
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        //DriverManager.setLogWriter(new PrintWriter("",""));
        Driver driver = DriverManager.getDriver("jdbc:derby:D:/geekbang;create=true");
        Connection connection = driver.connect("jdbc:derby:D:/geekbang;create=true" , new Properties());

        System.out.println(connection.isValid(5000));
        // 果然是驱动的问题，驱动版本不一致，导致的问题
        PreparedStatement stmt = connection.prepareStatement("select * from USERS");

        ResultSet rs = stmt.executeQuery();
        while (rs.next()){

            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getString(4));
            System.out.println(rs.getString(5));
        }

    }
}
