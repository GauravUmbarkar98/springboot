package util;
// Employee e =  Hr.getEmployee();

// Milk m = new Milk();
// Curd c = m.coagulate();
// Butter b  = c.churn();

//Butter b  = new Milk().coagulate().churn();

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

class MusicalInstrument { }
class MusicalInstrumentBuilder { } 

public class HibernateUtil {

	public static SessionFactory buildSessionFactory(String configFileName) //hibernate.cfg.xml
	{
		//read the xml file  hibernate.cfg.xml
		Configuration configuration = new Configuration().configure(configFileName);
		
		
		//make a key+value paired registry
		
		//MusicalInstrument i = new MusicalInstrumentBuilder().
		
		//key value service
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		return sessionFactory;
	}

	public static SessionFactory buildSessionFactory(Class<?>... persistentClasses) {
		Configuration configuration = new Configuration();
		for(Class<?> persistentClass : persistentClasses)
			configuration.addClass(persistentClass);
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public static SessionFactory buildAnnotatedSessionFactory(Class<?>... persistentClasses) {
		Configuration configuration = new Configuration();
		for(Class<?> persistentClass : persistentClasses)
			configuration.addAnnotatedClass(persistentClass);
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

}
