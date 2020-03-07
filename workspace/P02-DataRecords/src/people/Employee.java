package people;

public class Employee extends Person implements Comparable<Employee> {
	private final String 	office;
	private final double 	salary;
	private final int 		years;
	
	public Employee (Builder builder){
		super(builder.name, builder.age,builder.id,builder.willAttend);
		this.office = builder.office;
		this.salary= builder.salary;
		this.years = builder.years;
		
	}
	
	public Employee (Employee other) {
		super(other);
		this.office = other.office;
		this.salary= other.salary;
		this.years = other.years;
	}
	
	public static int compareSalary(Employee e1, Employee e2) {
		return (int)(e1.salary - e2.salary);
	}
	
	public int compareTo(Employee other) {
		if (!getLastName().equals(other.getLastName())) {
			return getLastName().compareTo(other.getLastName());
		}else if (!getFirstName().equals(other.getFirstName())) {
			return getFirstName().compareTo(other.getFirstName());
		}else if (getYears() != other.getYears()) {
			return getYears() - other.getYears();
		}else if (getSalary() != other.getSalary()) {
			return (int)(getSalary() - other.getSalary());
		}
		return getAge()-other.getAge();
	}
	
	public boolean equals(Object other) {
		if (other instanceof Employee) {
			Employee object = (Employee) other;
			return (
					name == object.name &&
					firstName == object.firstName &&
					lastName == object.lastName &&
					age == object.age &&
					id == object.id &&
					willAttend == object.willAttend &&
					office == object.office &&
					salary == object.salary &&
					years == object.years
					);
		}
		return false;
	}
	
	public double getSalary() {
		return salary;
	}
	public int getYears() {
		return years;
	}
	
	public double payments() {
		return salary/24;
	}
	
	public static int rankSalary(Employee e1,Employee e2) {
		if (e1.salary - e2.salary != 0) {
			return (int)(e1.salary - e2.salary);
		} 
		if (e1.name.compareTo(e2.name) != 0) {
			return e1.name.compareTo(e2.name);
		}
		if (e1.age - e2.age != 0) {
			return e1.age - e2.age;
		}
		return e1.years - e2.years;
	}
	
	public static int rankYears(Employee e1,Employee e2) {
		if (e1.years - e2.years != 0) {
			return (int)(e1.years - e2.years);
		} 
		if (e1.name.compareTo(e2.name) != 0) {
			return e1.name.compareTo(e2.name);
		}
		if (e1.salary - e2.salary != 0) {
			return (int)(e1.salary - e2.salary);
		} 
		return e1.age - e2.age;
		
	}
	
	public String toFile() {
		String s = super.toFile();
		s += ", Office, " + office;
		s += ", Salary, " + salary;
		s += ", Years, " + years;
		return s;
	}
	
	public String toString() {
		String s = super.toString();
		s += "\nOffice: " + "\t" + office;
		s += "\nSalary: " + "\t" + salary;
		s += "\nYears: " + "\t\t" + years;
		s += "\n";
		return s;
	}
	
	public static class Builder {
		private String name;
		private int age;
		private String id;
		private boolean willAttend;
		private String office;
		private double salary;
		private int years;
		
		public Builder() {};
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setAge(int age) {
			this.age = age;
			return this;
		}
		public Builder setID(String id) {
			this.id = id;
			return this;
		}
		public Builder setWillAttend(boolean willAttend) {
			this.willAttend = willAttend;
			return this;
		}
		public Builder setOffice(String office) {
			this.office = office;
			return this;
		}
		public Builder setSalary(double salary) {
			this.salary= salary;
			return this;
		}
		public Builder setYears(int years) {
			this.years= years;
			return this;
		}
		public Employee build() {
			return new Employee(this);
		}
	}
	
}
