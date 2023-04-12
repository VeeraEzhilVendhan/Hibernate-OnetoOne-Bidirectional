package com.spring.onetoone.bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class InstructorDetailsMain {
	
	public static void main(String[] args) 
	{
		SessionFactory sessionfactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .buildSessionFactory();
		
		Session session=sessionfactory.getCurrentSession();
		
		try
		{		
			session.beginTransaction();
			
			int id=2;
			
			InstructorDetails insdetl2=session.get(InstructorDetails.class, id);
			
			System.out.println(insdetl2);
			
			System.out.println(insdetl2.getInstructor());
						
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally
		{
			// handle leaking issue
			session.close();
			
			sessionfactory.close();
		}
		

	}

}
