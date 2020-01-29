package usertype;

public class Developer {

	private int id;
	private String name;
	private Boolean onBench;
	
	public Developer() {
		// TODO Auto-generated constructor stub
	}

	public Developer(String name, Boolean onBench) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.onBench = onBench;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean isOnBench() {
		return onBench;
	}

	public void setOnBench(Boolean onBench) {
		this.onBench = onBench;
	}	
}
