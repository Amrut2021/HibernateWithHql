package com.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.Entity.Vehicle;

public class InsertData {
	
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Vehicle.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		
		String hqlQuery="insert into Vehicle (name,color)values(:myname,:mycolor)";
		MutationQuery query=ss.createMutationQuery(hqlQuery);
		query.setParameter("myname", "Splendor");
		query.setParameter("mycolor", "Red");
		query.executeUpdate();
		tr.commit();
		ss.close();
		
		
	}

}
