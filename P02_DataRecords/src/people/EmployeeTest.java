package people;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee e1 = new Employee.Builder()
									.setOffice("STEM 101")
									.setSalary(56245)
									.setYears(20)
									.setAge(58)
									.setID("123456")
									.setName("Henry Le")									
									.setWillAttend(false)
									.build();
		System.out.println(e1.toFile());
		System.out.println(e1);
	}
}
