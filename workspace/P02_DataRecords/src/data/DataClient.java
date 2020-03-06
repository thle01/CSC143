package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.sun.glass.ui.CommonDialogs.Type;


public class DataClient {
	public static void main(String[] args) throws FileNotFoundException {
		String location = "U:\\\\CSC143\\\\workspace\\\\P02_DataRecords\\\\src\\\\People.txt";
		File f = new File(location);		
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			System.out.println(s);	
		}
		
		String string = "2:26 PM";
		String[] strings = string.substring(0,string.length()-2).split(":");
		
		System.out.println((Integer.parseInt(strings[0])));
		System.out.println(strings[1]);
		System.out.println(string.substring(string.length()-2));
		
	}
}
