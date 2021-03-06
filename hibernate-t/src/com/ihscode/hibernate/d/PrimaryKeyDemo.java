package com.ihscode.hibernate.d;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ihscode.hibernate.d.entity.Student;

public class PrimaryKeyDemo {
	
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session  = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			
			// create a 3 student objects
			System.out.println("Creating a new stduent object...");
			Student tempStudent1 = new Student("John", "Doe", "john@ihuscoding.com");
			Student tempStudent2 = new Student("akhu", "team", "akhu@ihuscoding.com");
			Student tempStudent3 = new Student("borotta", "Bhai", "borotta@ihuscoding.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		}
		finally {
			factory.close();
		}
					
				
	}
}
