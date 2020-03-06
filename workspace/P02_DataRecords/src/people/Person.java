package people;

public class Person {
	protected final String 		name;
	protected final String 		firstName;
	protected final String 		lastName;
	protected final int 		age;
	protected final String 		id;
	protected final boolean 	willAttend;
	
	public Person (Person other) {
		this.name = other.name;
		this.firstName = other.firstName;
		this.lastName = other.lastName;
		this.age = other.age;
		this.id = other.id;
		this.willAttend = other.willAttend;
	}
	
	public Person (String name, int age, String id, boolean willAttend) {
		this.name = "N/A";
		this.age = 0;
		this.id = "N/A";
		this.willAttend = false;
		this.firstName = "N/A";
		this.lastName = "N/A";
	}

	public String getName() {
		return name;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	public String getId() {
		return id;
	}
	public boolean isWillAttend() {
		return willAttend;
	}
	public int compareName(Person p1, Person p2) {
		return 1;
		//To-do
	}
	public boolean equals(Object other) {
		return true;
		//To-do
	}
	public String toFile() {
		return String.format("Name, %s, First Name, %s, Last Name, %s, age, %.2f, id, %d, willAttend, %"
							,name,firstName,lastName,age,id,willAttend);
	}
	
	public String toString() {
		return String.format("Name: \t%s\nFirst Name\t %s, Last Name\\t %s, Age\\t %.2f, ID\\t %d, willAttend\\t %"
				,name,firstName,lastName,age,id,willAttend);
	}
	
	
}
