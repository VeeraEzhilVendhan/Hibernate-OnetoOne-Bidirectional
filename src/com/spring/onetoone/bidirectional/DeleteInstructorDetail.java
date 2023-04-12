
package com.spring.onetoone.bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetail {
	
	public static void main(String[] args) {
		
		SessionFactory sessionfactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .buildSessionFactory();
		
		Session session=sessionfactory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			
			int id=4;
			
			InstructorDetails instdt2=session.get(InstructorDetails.class, id);
			
			
			// remove associated object reference
			instdt2.getInstructor().setInstructordetails(null);
			
			session.delete(instdt2);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally
		{
			session.close();
			sessionfactory.close();
		}
	}

}
