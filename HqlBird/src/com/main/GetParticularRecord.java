 package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Bird;

public class GetParticularRecord {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Bird.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery="from Bird where bid=:myId";
		Query<Bird>query=ss.createQuery(hqlQuery,Bird.class);
		query.setParameter("myId", 3);
		Bird bird = query.getSingleResult();
		
		System.out.println(bird);
		
		tr.commit();
		ss.close();
		
		
	}

}
