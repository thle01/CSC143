package tests;
import lists.ArrayList;
import utility.List; 

public class ArrayListTest {
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
//		a.add(6);
//		a.add(7);
//		a.add(8);
//		a.add(9);
		a.add(1,10);
		a.remove(0);
//		a.remove(7);
//		a.add(10);
//		a.add(11);
		a.add(12);
//		a.clear();
		System.out.println(a);
//		List<Integer> b = new ArrayList(a);
//		System.out.println(b);
		
		
		
	}
	
}
