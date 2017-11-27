package org.app.dbtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.*;

public class App {
    public static void main(String[] args) {

        DBConnect.getTriplet();
    }
}















































        /*List<Employee> employees = new DBOperations().getEmployees();
        System.out.print("EmpID | Employee Name | EmpSal");
        System.out.println();
        for(Employee emp:employees)
        {
            System.out.print(emp.geteId()+" |");
            System.out.print(emp.getEname()+"    | ");
            System.out.print(emp.geteSal());
            System.out.println();
        }*/
       /* DBOperations.getMap();
         new DBOperations().getTotalData();

        Stream.iterate(1, element->element+1)
                .filter(element->element%5==0)
                .limit(5)
                .forEach(System.out::println);*/
/*
        Function<Employee, String> funcEmpToString= (Employee e)-> {return e.getEname();};
        List<Employee> employeeList=
                Arrays.asList(new Employee("Tom Jones", 45),
                        new Employee("Harry Major", 25),
                        new Employee("Ethan Hardy", 65),
                        new Employee("Nancy Smith", 15),
                        new Employee("Deborah Sprightly", 29));
        Function<String,String> initialFunction= (String s)->s.substring(0,1);
        List<String> empNameListInitials=convertEmpListToNamesList(employeeList, funcEmpToString.andThen(initialFunction));
        empNameListInitials.forEach(str->{System.out.print(" "+str);});
    }
    public static List<String> convertEmpListToNamesList(List<Employee> employeeList, Function<Employee, String> funcEmpToString){
        List<String> empNameList=new ArrayList<>();
        for(Employee emp:employeeList){
            empNameList.add(funcEmpToString.apply(emp));
        }
        return empNameList;
    }*/

/*        Function<Employee, String> funcEmpToString= (Employee e)-> {return e.getEname();};
        Function<Employee, Employee> funcEmpFirstName=
                (Employee e)-> {int index= e.getEname().indexOf(" ");
                    String firstName=e.getEname().substring(0,index);
                    e.setEname(firstName);
                    return e;};
        List<Employee> employeeList=
                Arrays.asList(new Employee("Tom Jones", 45),
                        new Employee("Harry Major", 25),
                        new Employee("Ethan Hardy", 65),
                        new Employee("Nancy Smith", 15),
                        new Employee("Deborah Sprightly", 29));
        List<String> empFirstNameList= convertEmpListToNamesList(employeeList,funcEmpToString.compose(funcEmpFirstName));
        empFirstNameList.forEach(str->{System.out.print(" "+str);});
    }
    public static List<String> convertEmpListToNamesList(List<Employee> employeeList, Function<Employee, String> funcEmpToString){
        List<String> empNameList=new ArrayList<String>();
        for(Employee emp:employeeList){
            empNameList.add(funcEmpToString.apply(emp));
        }
        return empNameList;
    }*/
       /* Function<Employee, String> funcEmpToString= (Employee e)-> {return e.getEname();};
        List<Employee> employeeList=
                Arrays.asList(new Employee("Tom Jones", 45),
                        new Employee("Harry Major", 25),
                        new Employee("Ethan Hardy", 65),
                        new Employee("Nancy Smith", 15),
                        new Employee("Deborah Sprightly", 29));
        List<Employee> empNameListInitials=applyIdentityToEmpList(employeeList, Function.identity());
        empNameListInitials.forEach(System.out::println);
    }
    public static List<Employee> applyIdentityToEmpList(List<Employee> employeeList, Function<Employee, Employee> funcEmpToEmp){
        List<Employee> empNameList=new ArrayList<Employee>();
        for(Employee emp:employeeList){
            empNameList.add(funcEmpToEmp.apply(emp));
        }
        return empNameList;
    }*/