package events;

import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class MyIntegrator implements Integrator {

	@Override
	public void integrate(
            Configuration configuration,
            SessionFactoryImplementor sessionFactory,
            SessionFactoryServiceRegistry serviceRegistry) {
        
		EventListenerRegistry eventListenerRegistry = serviceRegistry.getService( EventListenerRegistry.class );

        //eventListenerRegistry.appendListeners( EventType.LOAD, new CustomListener());
        //eventListenerRegistry.appendListeners( EventType.FLUSH, new CustomListener());
    }

	@Override
	/** 
     * Ignore this form!  Just do nothing in impl.  It uses the new metamodel api slated for completion in 5.0
     */
	public void integrate(MetadataImplementor metadata,
			SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {
		
	}

	@Override
	public void disintegrate(SessionFactoryImplementor sessionFactory,
			SessionFactoryServiceRegistry serviceRegistry) {
		
	}

}
