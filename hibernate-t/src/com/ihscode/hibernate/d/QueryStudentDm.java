package com.ihscode.hibernate.d;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ihscode.hibernate.d.entity.Student;

public class QueryStudentDm {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session  = factory.getCurrentSession();
		
		try {	
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			// query students: lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Doe' ").getResultList();
			
			// display the students
			System.out.println("\n\nStudents who have last name of Doe");
			displayStudents(theStudents);
			
			// query students: lastName='Doe' OR
			
			
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		}
		finally {
			factory.close();
		}
					
				

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
