package com.utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {
    public static Connection getCon() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "system",
                "123456");
        return con;
    }
    public static void close(AutoCloseable...closeables) throws Exception {
        for (AutoCloseable closeable:closeables) {
            if(closeable!=null)
                closeable.close();
        }
    }
}
