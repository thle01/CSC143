package people;

public class Visitor extends Person implements Comparable<Visitor> {
	ArrivalTime time; 
	
	public Visitor(Visitor other) {
		super(other.name,other.age,other.id,other.willAttend);
		this.time = other.time;
	}
	
	public Visitor(String name, int age, String id, ArrivalTime time, boolean willAttend) {
		super(name,age,id,willAttend);
		this.time = time;
	}
	
	public static int compareByName(Visitor v1, Visitor v2) {
		if (v1.lastName.compareTo(v2.lastName) != 0) {
			return v1.lastName.compareTo(v2.lastName);
		}
		return v1.firstName.compareTo(v2.firstName);
	}
	
	public int compareTo(Visitor other) {
		if (lastName.compareTo(other.lastName) != 0) {
			return lastName.compareTo(other.lastName);
		}
		if (firstName.compareTo(other.firstName) != 0) {
			return firstName.compareTo(other.firstName);
		}
		if (time.compareTo(other.time) != 0) {
			return time.compareTo(other.time);
		} 
		return age - other.age;
		
	}
	
	public boolean equals(Object other) {
		if (other instanceof Visitor) {
			Visitor object = (Visitor) other;
			return (
					name == object.name &&
					firstName == object.firstName &&
					lastName == object.lastName &&
					age == object.age &&
					id == object.id &&
					willAttend == object.willAttend);
		}
		return false;
	}
	
	public String toFile() {
		String s = super.toFile();
		s += "," + time.toFile();
		return s;

	}
	
	public String toString() {
		String s = super.toString();
		s += time + "\n";
		return s;
	}
}
