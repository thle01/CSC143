package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modules.DModule;
import java.io.File;
import java.io.FileNotFoundException;
import people.ArrivalTime;
import people.Employee;
import people.Person;
import people.Visitor;
import java.io.PrintStream;

public class Filter {
	private List<Person> data;
	private List<Employee> employeeData;
	private List<Visitor> visitorData;

	public Filter() {
		data 			= new ArrayList<Person>();
		employeeData 	= new ArrayList<Employee>();
		visitorData 	= new ArrayList<Visitor>();
	}

	public void filterEmployeeSalary(String location) throws FileNotFoundException {

		String loc_1 = location + File.separator + "EmployeeSalaryUnder60k.txt";
		String loc_2 = location + File.separator + "EmployeeSalaryUnder60kCS.txt";
		String loc_3 = location + File.separator + "EmployeeSalaryOver60k.txt";
		String loc_4 = location + File.separator + "EmployeeSalaryOver60kCS.txt";

		File file_1 = new File(loc_1);
		File file_2 = new File(loc_2);
		File file_3 = new File(loc_3);
		File file_4 = new File(loc_4);

		PrintStream out_1 = new PrintStream(file_1);
		PrintStream out_2 = new PrintStream(file_2);
		PrintStream out_3 = new PrintStream(file_3);
		PrintStream out_4 = new PrintStream(file_4);

		DModule.maxSelectionSort(employeeData, Employee::rankSalary);

		if (file_1.exists() && file_2.exists() && file_3.exists() && file_4.exists()) {
			for (Employee employee : employeeData) {
				if (employee.getSalary() < 60000.00) {
					out_1.println(employee.toString());
					out_2.println(employee.toFile());
				} else {
					out_3.println(employee.toString());
					out_4.println(employee.toFile());
				}
			}
		}
		out_1.close();
		out_2.close();
		out_3.close();
		out_4.close();

	}

	public void filterEmplopyeeService(String location) throws FileNotFoundException {
		String loc_1 = location + File.separator + "EmployeeServiceOver10Years.txt";
		String loc_2 = location + File.separator + "EmployeeServiceOver10YearsCS.txt";
		String loc_3 = location + File.separator + "EmployeeServiceOver25Years.txt";
		String loc_4 = location + File.separator + "EmployeeServiceOver25YearsCS.txt";

		File file_1 = new File(loc_1);
		File file_2 = new File(loc_2);
		File file_3 = new File(loc_3);
		File file_4 = new File(loc_4);

		PrintStream out_1 = new PrintStream(file_1);
		PrintStream out_2 = new PrintStream(file_2);
		PrintStream out_3 = new PrintStream(file_3);
		PrintStream out_4 = new PrintStream(file_4);

		DModule.selectionSort(employeeData, Employee::rankYears);

		if (file_1.exists() && file_2.exists() && file_3.exists() && file_4.exists()) {
			for (Employee employee : employeeData) {
				if (employee.getYears() > 10 && employee.getYears() < 25) {
					out_1.println(employee.toString());
					out_2.println(employee.toFile());
				}
				if (employee.getYears() > 25) {
					out_3.println(employee.toString());
					out_4.println(employee.toFile());
				}
			}
		}
		out_1.close();
		out_2.close();
		out_3.close();
		out_4.close();
	}

	public void filterVisitorAge(String location) throws FileNotFoundException {
		String loc_1 = location + File.separator + "VisitorUnder21.txt";
		String loc_2 = location + File.separator + "VisitorUnder21CS.txt";
		String loc_3 = location + File.separator + "VisitorOver21.txt";
		String loc_4 = location + File.separator + "VisitorOver21CS.txt";

		File file_1 = new File(loc_1);
		File file_2 = new File(loc_2);
		File file_3 = new File(loc_3);
		File file_4 = new File(loc_4);

		PrintStream out_1 = new PrintStream(file_1);
		PrintStream out_2 = new PrintStream(file_2);
		PrintStream out_3 = new PrintStream(file_3);
		PrintStream out_4 = new PrintStream(file_4);

		DModule.bubbleSort(visitorData);

		if (file_1.exists() && file_2.exists() && file_3.exists() && file_4.exists()) {
			for (Visitor visitor : visitorData) {
				if (visitor.getAge() < 21) {
					out_1.println(visitor.toString());
					out_2.println(visitor.toFile());
				} else {
					out_3.println(visitor.toString());
					out_4.println(visitor.toFile());
				}
			}
		}
		out_1.close();
		out_2.close();
		out_3.close();
		out_4.close();
	}

	public void generateGalaLists(String location) throws FileNotFoundException {
		String loc_1 = location + File.separator + "VisitorGala.txt";
		String loc_2 = location + File.separator + "EmployeeGala.txt";
		String loc_3 = location + File.separator + "PersonGala.txt";

		File file_1 = new File(loc_1);
		File file_2 = new File(loc_2);
		File file_3 = new File(loc_3);

		PrintStream out_1 = new PrintStream(file_1);
		PrintStream out_2 = new PrintStream(file_2);
		PrintStream out_3 = new PrintStream(file_3);

		DModule.selectionSort(visitorData, Visitor::compareName);
		DModule.selectionSort(employeeData, Employee::compareName);
		DModule.selectionSort(data, Person::compareName);

		if (file_1.exists() && file_2.exists() && file_3.exists()) {
			for (Visitor visitor : visitorData) {
				if (visitor.getWillAttend() == true) {
					out_1.println(visitor.getName() + ", " + visitor.getAge());
				}
			}
			for (Employee employee : employeeData) {
				if (employee.getWillAttend() == true) {
					out_2.println(employee.getName() + ", " + employee.getAge());
				}
			}
			for (Person people : data) {
				if (people.getWillAttend() == true) {
					out_3.println(people.getName() + ", " + people.getAge());
				}
			}
		}
		out_1.close();
		out_2.close();
		out_3.close();
	}

	public ArrivalTime makeArrivalTime(String str) {
		String[] a = str.split(":");
		String[] b = a[1].split(" ");

		ArrivalTime arrivalTime = new ArrivalTime(Integer.parseInt(a[0]), Integer.parseInt(b[0]), b[1]);
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

			return new Employee.Builder().setName(name).setAge(age).setID(id).setWillAttend(willAttend)
					.setOffice(office).setSalary(salary).setYears(years).build();
		} else {
			ArrivalTime time = makeArrivalTime(info[4]);
			return new Visitor(name, age, id, time, willAttend);
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
			if (!data.contains(person)) {
				data.add(person);				
			}
			if (person instanceof Employee) {
				employee = (Employee) person;
				if (!employeeData.contains(employee)) {
					employeeData.add(employee);
				}
			} else if (person instanceof Visitor) {
				visitor = (Visitor) person;
				if (!visitorData.contains(visitor)) {
					visitorData.add(visitor);
				}
			}
		}
		inputFile.close();
	}

}
