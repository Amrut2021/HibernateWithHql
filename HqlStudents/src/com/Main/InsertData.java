package com.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.Entity.Students1;

public class InsertData {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Students1.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		String hqlQuery="insert into Students1(name,city,gender,age)values(:name,:city,:gender,:age)";
		MutationQuery query=ss.createMutationQuery(hqlQuery);
		query.setParameter("name", "Sai");
		query.setParameter("city","Satara");
		query.setParameter("gender","Female");
		query.setParameter("age", 22);
		query.executeUpdate();
		tr.commit();
		ss.close();
	}

}
