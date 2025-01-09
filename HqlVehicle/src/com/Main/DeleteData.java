package com.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.Entity.Vehicle;

public class DeleteData {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Vehicle.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		String hqlQuery="delete from Vehicle where id=:myid";
		MutationQuery query=ss.createMutationQuery(hqlQuery);
		query.setParameter("myid",7);
		query.executeUpdate();
		tr.commit();
	}

}
