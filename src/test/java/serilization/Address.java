package serilization;

public class Address {
	
	public String id;
	public String name;
	public String title;
	
	public Address(String id, String name, String title){
		this.id=id;
		this.name=name;
		this.title=title;
	}
	
	public Address() {}
	
	public String getName() {
		
		return name;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setName(String name) {
		this.name = name;
	}

}



 
 