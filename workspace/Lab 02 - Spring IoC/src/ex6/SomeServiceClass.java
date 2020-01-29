package ex6;

import java.util.Properties;

public class SomeServiceClass {

	private Properties adminEmails;

	public void setAdminEmails(Properties adminEmails) {
		System.out.println("setAdminEmails(Properties)");
		this.adminEmails = adminEmails;
	}

	public Properties getAdminEmails() {
		System.out.println("Properties getAdminEmails()");
		return adminEmails;
	}
}



