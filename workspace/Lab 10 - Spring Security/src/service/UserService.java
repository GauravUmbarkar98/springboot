package service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public void addNewUser() {
		System.out.println("addNewUser invoked...");
		
	}
	
	@Secured({"ROLE_ADMIN"})
	public void deleteUser() {
		System.out.println("deleteUser invoked...");
	}
}
