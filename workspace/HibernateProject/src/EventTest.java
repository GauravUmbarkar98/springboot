import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.tutorial.domain.Event;
import org.junit.Test;

import dao.BaseDAO;


public class EventTest {

	@Test
	public void addEvent()
	{
		Event theEvent = new Event();
		theEvent.setDate(new Date());
		theEvent.setTitle("My Birthday");
		
		BaseDAO dao = new BaseDAO();
		//dao.insert(theEvent);
		dao.insertOrUpdate(theEvent);
		
	}
	
	@Test
	public void getEvent() {
		BaseDAO dao = new BaseDAO();
		
		Event theEvent = dao.select(Event.class, 4L);
		theEvent.setTitle("Her BirthDay");
		System.out.println("updating new title...");
		
		//dao.update(theEvent);
		dao.insertOrUpdate(theEvent);
		System.out.println("updated new title...");
	}
	
	@Test
	public void getAllEvents() {
		BaseDAO dao = new BaseDAO();
		
		List <Event> allEvents = dao.selectAll(Event.class);
		
		System.out.println("Reading all events..");
		
		for (Event theEvent : allEvents) {
			
			System.out.println("Event ID    : "+theEvent.getId());
			System.out.println("Event Title : "+theEvent.getTitle());
			System.out.println("Event Date  : "+theEvent.getDate());
			System.out.println("---------------------------------");
		}
	}

}
