package com.spring.onetoone.bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Delete {

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
			
			InstructorDetails ins1=session.get(InstructorDetails.class, id);			
			
			if(ins1!=null)
			{
				System.out.println(ins1);
			}
			
			
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
		finally
		{
			
		}
		

	}

}
