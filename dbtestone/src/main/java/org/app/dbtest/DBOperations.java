package org.app.dbtest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public static Session getSession() {
        org.hibernate.cfg.Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }

    public static Map<String, String> getMap()
    {
        Map<String, String> map = new HashMap<>();
        map.put("java","hiberNate");
        map.put(".Net","EntityFramework");
        map.forEach((name,value)->System.out.println(name+" "+value));
        return map;
    }

    public static void getTotalData()
    {
            Session session = getSession();
            //from Employee where ename like 'p%'
            session.createQuery("from Employee").list().forEach(System.out::println);
        /*List<Employee> employees = null;
        if(employees!=null)
            {
                System.out.println(employees);
            }
            else System.out.println(employees);*/
        session.close();
    }

    public static void getpersonData(int id)
    {
       Session session = getSession();
       Employee employee =(Employee) session.load(Employee.class,id);
        System.out.println(employee.getEname());
        session.close();
       if(employee!=null)
       {
           System.out.println(employee);
       }
    }

    public static void saveRecord()
    {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Employee emp = new Employee();
        emp.setEname("ankitjain");
        emp.seteSal(25815.12);
        Integer rows = (Integer)session.save(emp);
        tx.commit();
        session.close();
        System.out.println(rows);
        System.out.println("added object successfully");
    }
}
