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
	

}
