package com.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.Entity.Students1;

public class DeleteData {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Students1.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		String hqlQuery="delete from Students1 where id=:myid";
		MutationQuery query=ss.createMutationQuery(hqlQuery);
		query.setParameter("myid", 3);
		query.executeUpdate();
		tr.commit();
		ss.close();
		
		  
	}

}
