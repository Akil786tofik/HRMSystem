package com.hrms.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.classes.AdminLogin;

public class Admin_Login 
{
private static SessionFactory factory;
	
	private static void getFactory()
	{
		try
		{
		Configuration configuration=new Configuration();
		configuration.addAnnotatedClass(AdminLogin.class);
		configuration.configure("AdminLogin.cfg.xml");
		ServiceRegistry sr=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();		
		factory=configuration.buildSessionFactory(sr);
		System.out.println("hello");
		}catch(Exception e)
		{
			System.out.println(e);
		}		
	}
	public boolean insertRecord(AdminLogin adminlogin)
	{
		System.out.println("hello");
		getFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			session.save(adminlogin);
			tx.commit();
			return true;
		}
		catch(HibernateException e)
		{
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return false;
	}
}
