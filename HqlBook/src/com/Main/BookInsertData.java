package com.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.Entity.Book;

public class BookInsertData {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Book.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery="insert into Book(b_id,bname,author,noOfPages)values(:id,:name,:author,:nPages)";
		MutationQuery query=ss.createMutationQuery(hqlQuery);
		query.setParameter("id", 2);
		query.setParameter("name","C++");
		query.setParameter("author"," S.Radhakrishnan");
		query.setParameter("nPages", 987);
		query.executeUpdate();
		tr.commit();
		ss.close();
		

	}
	
	

}
