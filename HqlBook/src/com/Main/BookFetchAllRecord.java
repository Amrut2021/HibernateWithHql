 package com.Main;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.Entity.Book;

public class BookFetchAllRecord {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Book.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "from Book";
		Query<Book> query = ss.createQuery(hqlQuery, Book.class);
		List<Book> list = query.getResultList();
		for (Book book : list) {
			System.out.println(book);
		}
		tr.commit();
		ss.close();
		
	}

}
