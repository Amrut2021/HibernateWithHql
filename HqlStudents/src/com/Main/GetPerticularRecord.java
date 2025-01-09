package com.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.Entity.Students1;

public class GetPerticularRecord {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Students1.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		String hqlQuery ="from Students1 where id=:myid";
		Query<Students1>query=ss.createQuery(hqlQuery,Students1.class);
		query.setParameter("myid", 2);
		Students1 s=query.getSingleResult();
		System.out.println(s);
		tr.commit();
		ss.close();
		
		
	}

}
