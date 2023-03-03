package H_Project.HibernateMantyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//Configuration
    	Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
    	
        //System.out.println( "Hello World!" );
        SessionFactory factory = cfg.buildSessionFactory();
        System.out.println(factory.isClosed());
        		
        
        
        //Create Table Employee 1
        Employee e1 = new Employee();
        e1.setEmp_id(201);
        e1.setEmp_Name("pooja");
        e1.setEmp_Address("Yeola");
        
        //Create Table Employee 2
        Employee e2 = new Employee();
        e1.setEmp_id(202);
        e1.setEmp_Name("Nikita");
        e1.setEmp_Address("Kopergon");
        
        //Create Table Projects 1
        Project p1 = new Project();
        p1.setProject_id(101);
        p1.setProject_name("Travelling Management");
        
        //Create Table Projects 2
        Project p2 = new Project();
        p2.setProject_id(102);
        p2.setProject_name("Hostel Management");
        
        //Create Table Projects 3
        Project p3 = new Project();
        p3.setProject_id(103);
        p3.setProject_name("Hospital Management");
        
        //Create Table Projects 1
        Project p4 = new Project();
        p1.setProject_id(104);
        p1.setProject_name("Library Management");
        
        //Creating List Of Employee And Project
        List<Employee>emp =  new ArrayList<Employee>();
        List<Project>pro = new ArrayList<Project>();
        
        pro.add(p1);
        pro.add(p3);
        pro.add(p4);
        e1.setProject(pro);
        
        emp.add(e1);
        emp.add(e2);
        p1.setEmployee(emp);
        
        //Opening the session
		Session session = factory.openSession();
		  
		//Begin the transaction
		Transaction tx = session.beginTransaction();
		
        //Saving the values of Student Table
        session.save(e1);
        session.save(e2);
        //Saving the values of Department Table
        session.save(p1);
        session.save(p2);
        session.save(p3);
        session.save(p4);
        
        //commit
        tx.commit();
        
        //Closing Session And Factory
        session.close();
        factory.close();
        
   }
}
