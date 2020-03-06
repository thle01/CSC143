package modules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;


public class DModuleTest {
	public static void main(String[] args) {
		 	
		  
	      List<Integer> items = new ArrayList<Integer>();
	      
	      items.add(22);
	      items.add(56);
	      items.add(10);
	      items.add(32);
	      items.add(67);
	      items.add(11);
	      items.add(55);
	      items.add(95);
	      items.add(66);
	      items.add(89);
	      
	      System.out.print("Unsorted Integer Array = ");
	      for (Integer item : items) {
	           System.out.print(item+" ");
	      }
//	      DModule.bubbleSort(items);
//	      DModule.insertionSort(items);
//	      DModule.selectionSort(items, new Comparator<T>());
//	      DModule.mergeSort(items);
	      DModule.quickSort(items);
	      System.out.print("\nSorted Integer Array = ");
	      for (Integer item : items) {
	           System.out.print(item+" ");
	      }
	   
	      int foundIndex = DModule.binarySearch(items, Integer.valueOf(22));
	      System.out.println("\nInteger Array Contains item 22 at index = " + foundIndex);
	 
	      foundIndex = DModule.binarySearch(items, Integer.valueOf(11));
	      System.out.println("Integer Array Contains item 11 at index = " + foundIndex);
	 
	      foundIndex = DModule.binarySearch(items, Integer.valueOf(67));
	      System.out.println("Integer Array Contains item 67 at index = " + foundIndex);
	 
	      foundIndex = DModule.binarySearch(items, Integer.valueOf(10));
	      System.out.println("Integer Array Contains item 10 at index = " + foundIndex);
	 
	      foundIndex = DModule.binarySearch(items, Integer.valueOf(101));
	      System.out.println("Integer Array Contains item 101 at index = " + foundIndex);
	 
	      System.out.println("First half " + DModule.splitFirstHalf(items));
	      System.out.println("Second half " + DModule.splitSecondHalf(items));
	      
	      /*
	       * 
	       */
	      List<String> strItems = new ArrayList<String>();
	      strItems.add("abc");
	      strItems.add("acb");
	      strItems.add("zyt");
	      strItems.add("fre");
	      strItems.add("nhy");
	      strItems.add("aa");
	      
	      System.out.print("\nUnsorted String Array = ");
	      for (String item : strItems) {
	           System.out.print(item+" ");
	      }
//	      DModule.bubbleSort(strItems);	    
//	      DModule.insertionSort(strItems);
//	      DModule.mergeSort(strItems);
	      DModule.quickSort(strItems);
	      System.out.print("\nSorted String Array = ");
	      for (String item : strItems) {
	           System.out.print(item+" ");
	      }
	   
	      foundIndex = DModule.binarySearch(strItems, "alk");
	      System.out.println("\nString Array Contains item alk at index = " + foundIndex);
	 
	      foundIndex = DModule.binarySearch(strItems, "nhy");
	      System.out.println("String Array Contains item nhy at index = " + foundIndex);
	 
	      foundIndex = DModule.binarySearch(strItems, "zyt");
	      System.out.println("String Array Contains item zyt at index = " + foundIndex);
	 
	      foundIndex = DModule.binarySearch(strItems, "zyts");
	      System.out.println("String Array Contains item zyts at index = " + foundIndex);
	      
	      System.out.println("First half " + DModule.splitFirstHalf(strItems));
	      System.out.println("Second half " + DModule.splitSecondHalf(strItems));
	 
	      /*
	       * 
	       */
	      List<Double> dItems = new ArrayList<Double>();
	      dItems.add(11.3);
	      dItems.add(13.3);
	      dItems.add(6.34);
	      dItems.add(9.6);
	      dItems.add(45.7);
	      dItems.add(23.1);
	      
	      System.out.print("\nUnsorted Double Array = ");
	      for (Double item : dItems) {
	           System.out.print(item+" ");
	      }
//	      DModule.bubbleSort(dItems);
//	      DModule.insertionSort(dItems);
//	      DModule.mergeSort(dItems);
	      DModule.quickSort(dItems);	      
	      System.out.print("\nSorted Double Array = ");
	      for (Double item : dItems) {
	           System.out.print(item+" ");
	      }
	   
	      foundIndex = DModule.binarySearch(dItems, 13.3);
	      System.out.println("\nDouble Array Contains item 13.3 at index = " + foundIndex);
	 
	      foundIndex = DModule.binarySearch(dItems, 14.3);
	      System.out.println("Double Array Contains item 14.3 at index = " + foundIndex);
	 
	      foundIndex = DModule.binarySearch(dItems, 23.0);
	      System.out.println("Double Array Contains item 23.0 at index = " + foundIndex);
	      
	      System.out.println("First half " + DModule.splitFirstHalf(dItems));
	      System.out.println("Second half " + DModule.splitSecondHalf(dItems));
	      
	      DModule.maxInsertionSort(dItems);	      
	      System.out.print("\nDescending Sorted Double Array = ");
	      for (Double item : dItems) {
	           System.out.print(item+" ");
	      }
	}
}
