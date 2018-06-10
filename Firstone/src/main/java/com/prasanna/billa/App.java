package com.prasanna.billa;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student  =(Student)context.getBean("studentbean");
        Address address  =(Address) context.getBean("addressBean");
        System.out.println(address.getLocation());
        student.displayInfo();
        System.out.println(student.toString());
        List<Courses> courses = student.getCourses();
        courses.forEach(courses1 -> System.out.println(courses1.getCourseId()+" "+courses1.getCourseName()));

        System.out.println("===============================================================================");
        Book book = (Book)context.getBean("bookBean");

        System.out.println(book.toString());
        System.out.println("*******************************************************************************");
        Book bookc = (Book)context.getBean("bookcBean");

        System.out.println(bookc.toString());

        System.out.println("===============================================================================");
        System.out.println("===============================================================================");
        ArrayList<Integer> arrayList =(ArrayList)context.getBean("listBean");
        System.out.println("List");
        arrayList.forEach(param-> System.out.println(param));
        System.out.println("*************");
        HashMap<String, Object> hashMap =(HashMap)context.getBean("mapBean");
        System.out.println("Map");
        hashMap.forEach((key,value)-> System.out.println("key "+key +" value "+value));
        System.out.println("*************");
        HashSet<String> hashSet =(HashSet)context.getBean("setBean");
        System.out.println("SET");
        hashSet.forEach(param-> System.out.println(param));
        System.out.println("*************");
        Properties properties =(Properties) context.getBean("propBean");
        System.out.println("Poperties");
        properties.forEach((key,value)-> System.out.println("Key "+key+" value "+value));
        System.out.println("*************");

        System.out.println("===============================================================================");
        System.out.println("===============================================================================");


        NewSystem newSystem = (NewSystem)context.getBean("newSystemObj");
        System.out.println(newSystem.toString());

    }
}
