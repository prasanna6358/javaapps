package org.app.dbtest;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnect {

    public static  Connection connection=null;
    public static  String driver;
    public static String url;
    public static String userName;
    public static String password;

    public static final Connection getConnection()
    {
        if(connection!=null)
        {
            return connection;
        }
        else
        {
            try {
                Properties properties = new Properties();
                InputStream inputStream = DBConnect.class.getClassLoader().getResourceAsStream("database.properties");
                if (inputStream != null) {
                    properties.load(inputStream);
                    driver = properties.getProperty("driver");
                    url = properties.getProperty("url");
                    userName = properties.getProperty("user");
                    password = properties.getProperty("password");
                    Class.forName(driver);
                    connection = DriverManager.getConnection(url, userName, password);
                   }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return connection;
        }
    }
}
