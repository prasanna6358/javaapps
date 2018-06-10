package datab.dbsql.dbsource;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class DBTest {
    public static void main(String[] args) {
        ApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml");
        HibernateTemplate hibernateTemplate  = (HibernateTemplate) context.getBean("HTObject");
        hibernateTemplate.setCheckWriteOperations(false);
        //hibernateTemplate.setCheckWriteOpeations(true);
        SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
        Session session = sessionFactory.openSession();
        //session.setDefaultReadOnly(false);
        session.setFlushMode(FlushMode.COMMIT);
        Transaction transaction = session.beginTransaction();
        ORMUser ormUser = new ORMUser();
        ormUser.setId(122);
        ormUser.setCountry("INDIA");
        ormUser.setName("Ankit");
        ormUser.setEmail("ankit@gmail.com");
        ormUser.setPassword("ankit@123");
        int id = (Integer)hibernateTemplate.save(ormUser);
        ORMUser obj = (ORMUser)hibernateTemplate.get(ORMUser.class,121);
        System.out.println(obj.getName());
        transaction.commit();
        session.flush();
        /* JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");

        String sql = "insert into user(Name,Password,Email,Country) values(?,?,?,?)";
        int c = jdbcTemplate.update(sql,"raman","raman@123","raman@gmail.com","INDIA");
        if(c>0){
            System.out.println("Record saved successfully");
        }
        else System.out.println("Record not saved");*/

        /*UserRowMapper userRowMapper = new UserRowMapper();
        List<User> list = jdbcTemplate.query("select * from user",userRowMapper);
        list.forEach(param-> System.out.println("Id: "+param.getId()+" \tName: "+param.getName()+"\tEmail: "+param.getEmail()
                +"\tPassowrd: "+param.getPassword()+"Country: "+param.getCountry()));*/


    }
}
