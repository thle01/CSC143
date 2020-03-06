package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import people.ArrivalTime;
import people.Employee;
import people.Employee.Builder;
import people.Person;
import people.Visitor;

public class Filter {
	private final List<Person> data;
	private final List<Employee> employeeData;
	private final List<Visitor> visitorData;

	public Filter() {
		data = new ArrayList<Person>();
		employeeData = new ArrayList<Employee>();
		visitorData = new ArrayList<Visitor>();
	}

	public void filterEmployeeSalary(String location) throws FileNotFoundException {

	}

	public void filterEmplopyeeService(String location) throws FileNotFoundException {

	}

	public void filterVisitorAge(String location) throws FileNotFoundException {

	}

	public void generateGalaLists(String location) throws FileNotFoundException {

	}

	public ArrivalTime makeArrivalTime(String str) {
		String[] strings = str.substring(0,str.length()-2).split(":");
		ArrivalTime arrivalTime = new ArrivalTime(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), str.substring(str.length()-2));
		return arrivalTime;
	}

	public Person parse(String line) throws IllegalArgumentException {

		String[] info = line.split(", ");
		String name = info[0];
		int age = Integer.parseInt(info[1]);
		String id = info[2];
		boolean willAttend = info[3].equalsIgnoreCase("Yes");

		if (id.charAt(0) == 'E') {
			String office = info[4];
			double salary = Double.parseDouble(info[5]);
			int years = Integer.parseInt(info[6]);

			return new Employee.Builder().setName(name).setAge(age).setID(id).setOffice(office).setSalary(salary)
					.setWillAttend(willAttend).build();
		} else {
			ArrivalTime time = new makeArrivalTime(info[4]);
			return new Visitor(name, age, id, willAttend);
		}

	}

	public void read(String location) throws FileNotFoundException {
		File file = new File(location);
		Scanner inputFile = new Scanner(file);
		Person person;
		Employee employee;
		Visitor visitor;

		while (inputFile.hasNextLine()) {
			person = parse(inputFile.nextLine());

			if (person instanceof Employee) {
				employee = (Employee) person;
				if (!employeeData.contains(employee)) {
					employeeData.add(employee);
				}
			} else if (person instanceof Visitor) {
				visitor = (Visitor) person;
				if (!visitorData.contains(visitor)) {
					visitorData.add(employee);
				}
			}
		}
		inputFile.close();
	}

}
