package testing;

import modules.RecModule;

public class RecTest {

	public static void main(String[] args) {
		int[] data = {2, 9, 5, 4, 8, 1, 6};
		print(data);
		RecModule.selectionSort(data);
		print(data);

	}
	
	public static void print(int[] list) {
		
		for(int i = 0; i < list.length; i++) {
			System.out.print("[" + i + "]");
		}
		System.out.println();
		
		//use a for-each loop to print out data
		for(int data : list) {
			System.out.print(" " + data + " ");
		}
		System.out.println();
		System.out.println();
	}

	

}
