package com.zlikun.jee.j06_1;

import org.junit.Test;

import java.sql.*;

/**
 * 使用try-with-resources诗句实现JDBC操作
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018/8/6 18:16
 */
public class JdbcTest {

    @Test
    public void test() throws ClassNotFoundException, SQLException {

        // 连接对象自动管理
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://192.168.0.105:3306/test", "root", "123456")) {
            // Statement和ResultSet对象被自动管理
            try (
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT VERSION()");
            ) {
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            }

        }

    }

}
