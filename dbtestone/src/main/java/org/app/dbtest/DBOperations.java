package org.app.dbtest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {

    public static Connection con;

    public DBOperations()
    {

    }

    public List<Employee> getEmployees()
    {
        con = DBConnect.getConnection();
        List<Employee> employees = new ArrayList<Employee>();
        try{
            PreparedStatement prepareStatement= con.prepareStatement("select * from Employee");
            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next())
            {
                Employee employee = new Employee();
                employee.seteId(rs.getInt(1));
                employee.setEname(rs.getString(2));
                employee.seteSal(rs.getDouble(3));
                employees.add(employee);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return employees;
    }

    public  void getDatafromDB()
    {
        org.hibernate.cfg.Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Employee emp = (Employee)session.get("org.app.dbtest.Employee",14);
        if(emp!=null) {
            System.out.println(emp.getEname());
            System.out.println(emp.geteSal());
        }
        else System.out.println("session not found");
        session.close();
        sessionFactory.close();
    }
}
