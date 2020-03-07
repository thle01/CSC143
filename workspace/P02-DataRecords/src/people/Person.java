package people;

public class Person {
	String name;
	String firstName;
	String lastName;
	int age;
	String id;
	boolean willAttend;

	public Person(Person other) {
		this.name = other.name;
		this.firstName = other.firstName;
		this.lastName = other.lastName;
		this.age = other.age;
		this.id = other.id;
		this.willAttend = other.willAttend;
	}

	public Person(String name, int age, String id, boolean willAttend) {
		this.name = name;
		String[] a = name.split(" ");
		this.firstName = a[0];
		this.lastName = a[1];
		this.age = age;
		this.id = id;
		this.willAttend = willAttend;
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

	public boolean getWillAttend() {
		return willAttend;
	}

	public static int compareName(Person p1, Person p2) {
		if (p1.lastName.compareTo(p2.lastName) != 0) {
			return p1.lastName.compareTo(p2.lastName);
		}
		if (p1.firstName.compareTo(p2.firstName) != 0) {
			return p1.firstName.compareTo(p2.firstName);
		} else
			return p1.age - p2.age;
	}

	public boolean equals(Object other) {
		if (other instanceof Person) {
			Person object = (Person) other;
			return (name == object.name && firstName == object.firstName && lastName == object.lastName
					&& age == object.age && id == object.id && willAttend == object.willAttend);
		}
		return false;
	}

	public String toFile() {
		String attend = (willAttend) ? "YES" : "NO";
		String s = "";
		s += "Name, " + name;
		s += ", First Name, " + firstName;
		s += ", Last Name, " + lastName;
		s += ", Age, " + age;
		s += ", ID, " + id;
		s += ", Will Attend, " + attend;

		return s;
	}

	public String toString() {
		String attend = (willAttend) ? "YES" : "NO";
		String s = "";
		s += "Name: " + "\t\t" + name;
		s += "\nFirst Name: " + "\t" + firstName;
		s += "\nLast Name: " + "\t" + lastName;
		s += "\nAge: " + "\t\t" + age;
		s += "\nID: " + "\t\t" + id;
		s += "\nWill Attend: " + "\t" + attend;

		return s;
	}

}
