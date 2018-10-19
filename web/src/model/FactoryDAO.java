package model;

import javax.ejb.Startup;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Startup
public final class FactoryDAO {

	private FactoryDAO() {
		openInstance();
	}

	private static Configuration cfg;
	private static SessionFactory sessionFactory;
	private static Session session;

	public static Session openInstance() {
		if (session == null) {
			cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
		}

		return session;
	}

	public static void closeInstance() {
		openInstance();
		session.close();
		sessionFactory.close();

		session = null;
		sessionFactory = null;
		cfg = null;
	}

//	public static SessionFactory sessionFactory() {
//
//		if (sessionFactory == null) {
//			sessionInstance();
//		}
//
//		return sessionFactory;
//	}

}
