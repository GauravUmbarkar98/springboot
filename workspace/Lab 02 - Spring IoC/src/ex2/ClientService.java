package ex2;

public class ClientService {
	private static ClientService clientService;

	private ClientService() {
		System.out.println("Private Ctor ClientService is invoked...");
	}

	public static ClientService createInstance() {
		System.out.println("createInstance is invoked...");
		if(clientService == null)
			 clientService = new ClientService();
		return clientService;
	}
	
}
