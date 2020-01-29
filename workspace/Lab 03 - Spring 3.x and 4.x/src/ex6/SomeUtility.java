package ex6;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeUtility {

	@Autowired
	private List<Dao> listOfDaos;
	
	@PostConstruct
	public void init() {
		System.out.println(listOfDaos);
		for(Dao dao : listOfDaos) {
			//some initializing logic for the daos
		}
	}
	
}
