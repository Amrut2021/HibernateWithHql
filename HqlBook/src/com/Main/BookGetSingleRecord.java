package com.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.Entity.Book;

public class BookGetSingleRecord {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Book.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "from Book where b_id=:myId";
		Query<Book> query = ss.createQuery(hqlQuery, Book.class);
		query.setParameter("myId", 2);
		Book b=query.getSingleResult();
		System.out.println(b);
		tr.commit();
		

	}

}
