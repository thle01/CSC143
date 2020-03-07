package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import people.ArrivalTime;


public class DataClient {
	public static void main(String[] args) throws FileNotFoundException {
		String fileLocation = File.separator + "Users" 
				+ File.separator + "mynga"
				+ File.separator + "OneDrive"
				+ File.separator + "Desktop"
				+ File.separator + "CSC143"
				+ File.separator + "workspace"
				+ File.separator + "P02-DataRecords"
				+ File.separator + "src"
				+ File.separator
				;
		
		Filter f1 = new Filter();
		f1.read(fileLocation + "People.txt");
		f1.filterEmployeeSalary(fileLocation);
		f1.filterEmplopyeeService(fileLocation);
		f1.filterVisitorAge(fileLocation);
		f1.generateGalaLists(fileLocation);
		
//		System.out.println(f1.employeeData);
//		System.out.println(f1.data);
//		System.out.println(f1.visitorData);
	}
}
