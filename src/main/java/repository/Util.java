package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static Util util;
    private static String JDBC_DRIVER = "org.postgresql.Driver";
    private static String DATABASE_URL = "jdbc:postgresql://localhost:5432/andersen";
    private static String USER = "postgres";
    private static String PASSWORD = "root";

    public static Util getUtil(){
        if(util == null){
            util = new Util();
        }
        return util;
    }

    private Util(){}

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }
}
