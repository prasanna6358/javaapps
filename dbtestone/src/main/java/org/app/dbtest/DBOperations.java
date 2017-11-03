package org.app.dbtest;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {

    public final Connection con;

    public DBOperations()
    {
        con = DBConnect.getConnection();
    }

    public List<Employee> getEmployees()
    {
        List<Employee> employees = new ArrayList<Employee>();
        try{
            PreparedStatement prepareStatement= con.prepareStatement("select * from Employee");
            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next())
            {
                Employee employee = new Employee();
                employee.seteId(rs.getInt(1));
                employee.setEname(rs.getString(2));
                employee.seteSal(rs.getString(3));
                employees.add(employee);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return employees;
    }
}
