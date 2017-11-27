package org.app.dbtest;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

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

    public  static void getTriplet()
    {
        Scanner scanner  = new Scanner(System.in);
        int noofTests = scanner.nextInt();
        int a,b,c;
        for(int i=0;i<noofTests;i++)
        {
            scanner  = new Scanner(System.in);
            String firstLine = scanner.nextLine().trim();
            String[] str1 = firstLine.split(" ");
            a = Integer.parseInt(str1[0]);
            b = Integer.parseInt(str1[1]);
            c = Integer.parseInt(str1[2]);
            if(c*c==a*a+b*b)
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
        }
    }
}
