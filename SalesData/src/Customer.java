
public class Customer {

	String firstname;
	String lastname; 
	int age;
	int id; 
	
	
	Customer(int id, String firstname, String lastname, int age) 
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age; 
		this.id = id; 
		
	}
	
	String getFirstname() {return this.firstname;}
	String getLastname() {return this.lastname;}
	int getId() {return this.id;}
	int getAge() {return this.age;}
	
	
}
