package events;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.FlushEvent;
import org.hibernate.event.spi.FlushEventListener;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;

public class CustomListener implements LoadEventListener, FlushEventListener {


	@Override
	public void onLoad(LoadEvent event, LoadType type) throws HibernateException {
		System.out.println("onLoad called..");
	}

	@Override
	public void onFlush(FlushEvent event) throws HibernateException {
		System.out.println("onFlush called..");
	}
	
}
