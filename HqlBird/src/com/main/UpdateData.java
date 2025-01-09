package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;


import com.entity.Bird;

public class UpdateData {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Bird.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery="update Bird set bName=:myName where bid=:myid";
		MutationQuery query=ss.createMutationQuery(hqlQuery);
		query.setParameter("myName", "Dove");
		query.setParameter("myid", 4);
		query.executeUpdate();
		tr.commit();
		ss.close();
	}

}
