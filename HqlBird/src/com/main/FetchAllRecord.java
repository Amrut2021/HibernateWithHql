package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Bird;

public class FetchAllRecord {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Bird.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery="from Bird";
		Query<Bird>query=ss.createQuery(hqlQuery,Bird.class);
		List<Bird> list=query.getResultList();
		for(Bird bird:list) {
			System.out.println(bird);
		}
		tr.commit();
		ss.close();
	}
}
