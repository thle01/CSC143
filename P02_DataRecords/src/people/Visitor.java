package people;

public class Visitor extends Person implements Comparable<Visitor> {
	private final ArrivalTime time; 
	
	public Visitor(Visitor other) {
		
	}
	
	public Visitor(String name, int age, String id, boolean willAttend) {
		super(name,age,id,willAttend);
	}
	
	public int compareByName(Person p1, Person p2) {
		return 1;
	}
	public int compareTo(Person p1, Person p2) {
		return 1;
	}
	public boolean equals(Object other) {
		return true;
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
