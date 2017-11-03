package org.app.dbtest;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        List<Employee> employees = new DBOperations().getEmployees();
        System.out.print("EmpID | Employee Name | EmpSal");
        System.out.println();
        for(Employee emp:employees)
        {
            System.out.print(emp.geteId()+" |");
            System.out.print(emp.getEname()+"    | ");
            System.out.print(emp.geteSal());
            System.out.println();
        }
    }
}
