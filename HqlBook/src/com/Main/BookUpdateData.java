package com.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.Entity.Book;

public class BookUpdateData {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Book.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery="update Book set bname=:myName where b_id=:myId";
		MutationQuery query=ss.createMutationQuery(hqlQuery);
		query.setParameter("myName", "Learning Java");
		query.setParameter("myId", 1);
		query.executeUpdate();
		tr.commit();
		ss.close();

	}

}
