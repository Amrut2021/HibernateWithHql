package com.Main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.Entity.Students1;

public class FetchAllRecord {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Students1.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		String hqlQuery="from Students1";
		Query<Students1>query=ss.createQuery(hqlQuery,Students1.class);
		
		List<Students1>list= query.getResultList();
		for(Students1 s:list) {
			System.out.println(s);
		}
		tr.commit();
		ss.close();
		
	}
}
