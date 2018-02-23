package org.apache.olingo.sample.client;

import java.util.*;  
import java.sql.*;  
  
public class EmpDao {


    public static void main(String[] args) {
        System.out.println(getAllEmployees());
    }
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/billa","root","billaprasanna");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Student e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into Student(sname,collegeName,email) values (?,?,?)");  
            ps.setString(1,e.getSname());  
            ps.setString(2,e.getCollegeName());  
            ps.setString(3,e.getEmail());    
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Student e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update Student set sname=?,collegeName=?,email=? where sid=?");  
            ps.setString(1,e.getSname());  
            ps.setString(2,e.getCollegeName());  
            ps.setString(3,e.getEmail()); 
            ps.setInt(4,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from Student where sid=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Student getEmployeeById(int id){  
        Student e=new Student();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Student where sid=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt("sid"));  
                e.setSname(rs.getString("sname"));    
                e.setEmail(rs.getString("email"));  
                e.setCollegeName(rs.getString("collegeName"));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Student> getAllEmployees(){  
        List<Student> list=new ArrayList<Student>();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Student");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Student e=new Student();  
                e.setId(rs.getInt("sid"));  
                e.setSname(rs.getString("sname"));    
                e.setEmail(rs.getString("email"));  
                e.setCollegeName(rs.getString("collegeName"));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  
