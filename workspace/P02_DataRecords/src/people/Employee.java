package people;

public class Employee extends Person implements Comparable<Employee> {
//	private final String 	name;
//	private final int 		age;
//	private final String 	id;
//	private final boolean 	willAttend;
	private final String 	office;
	private final double 	salary;
	private final int 		years;
	
	public Employee (Builder builder){
//		this.name = builder.name;
//		this.age = builder.age;
//		this.id = builder.id;
//		this.willAttend = builder.willAttend;
		this.office = builder.office;
		this.salary= builder.salary;
		this.years = builder.years;
		
	}
	
	public Employee (Employee other) {
		this.office = other.office;
		this.salary= other.salary;
		this.years = other.years;
	}
	
	public static int compareSalary(Employee e1, Employee e2) {
		return (int)(e1.salary - e2.salary);
	}
	
	public int compareTo(Employee other) {
		return 1;
		//compare employee in their natural order
		//To-do
	}
	
	public boolean equals(Object other) {
		return true;
		//To-do
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
		return 1;
		//the order of ranking by salary, then by name, age and service
		//To-do
	}
	
	public static int rankYears(Employee e1,Employee e2) {
		return 2; 
		//the order of ranking by years of service, then by name, salary and age
		//To-do
	}
	
	public String toFile() {
		return String.format("Name, %s, Age, %d, ID, %s, Gala, %b, Office, %s, Salary, %.2f"
				+ ", Service, %d, Bi-Monthly, %.2f"
				, name, age, id, willAttend, office, salary, years, payments());
	}
	
	public String toString() {
		String willAttendText = willAttend ? "YES" : "NO";
		return String.format(" Name:\t\t%s\n Age:\t\t%d\n ID:\t\t%s\n Gala:\t\t%s\n Office:\t%s\n "
				+ "Salary:\t%.2f\n Service:\t %d\n Bi-Monthly:\t %.2f"
				, name, age, id, willAttendText, office, salary, years, payments());
	}
	
	public static class Builder {
		private String name;
		private int age;
		private String id;
		private boolean willAttend;
		private String office;
		private double salary;
		private int years;
		
		public Builder() {
			setAge(0);
			setID("N/A");
			setName("N/A");
			setOffice("N/A");
			setSalary(0);
			setWillAttend(false);
			setYears(0);
		}
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
