package modules;


public class ArrayModule {
	
	public static int binarySearch(int[] list, int target) {
		int mid, low, high;
		
		low = 0;
		high = list.length-1;
		
		while(high > low) {
			mid = (high+low)/2;
			
			if (target > list[mid]) {
				high = mid - 1;
			}
			else if (target < list[mid]) {
				high = low + 1;
			}
			else {
				return mid;
			}
		}
		
		return -1;
	}

	public static  void bubbleSort(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = 0; j < list.length - i - 1; j++) {
				if (list[j] > list[j+1]) {
					int temp = list[j+1];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
		}
	}
	
	public static boolean contains(int[] list, int target) {
		for (int i: list) {
			if (i == target)
				return true;
		}
		return false;
	}
	
	public static int indexOf(int[] list, int target) {
		for (int i = 0; i<list.length; i++) {
			if (list[i] == target)
				return i;
		}
		return -1;
	}
	
	public static void insertionSort(int[] list) {
		int i,j,temp;
		for (i = 1;i<list.length-1;i++) {
			j = i;
			
			while (j > 0 && list[j] < list[j - 1]) {

	            temp = list[j];
	            list[j] = list[j - 1];
	            list[j - 1] = temp;
	            --j;
	         }
		}
	}

	
	private static void merge(int[] list, int[] firstHalf, int[] secondHalf) {
		
	}
	
	public static void mergeSort(int[] list) {
		splitFirstHalf(null);
		splitSecondHalf(null);
		merge(null, null, null);
	}
	
	private static int partition(int[] list, int low, int high) {

		return 0;
	}
	
	public static void quickSort(int[] list) {
		quickSort(list, 0, list.length - 1);	
	}
	
	private static void quickSort(int[] list, int left, int right) {
		partition(list, 0, 0);
	}
	

	
	public static void selectionSort(int[] list) {
				
		for (int i =0; i < list.length-1; i++) {
			int indexSmallest = i;
			for (int j=i+1;j<list.length; j++) {
				if (list[i]<list[indexSmallest])
					indexSmallest = i;
			}
			int temp = list[i];
			list[i] = list[indexSmallest];
			list[indexSmallest] = temp;
		}
		
		
	}
	
	private static int[] splitFirstHalf(int[] list) {
		return null;
	}
	
	private static int[] splitSecondHalf(int[] list) {
		return null;
	}
	
	public static void swap(int[] list, int first, int second) {
		
	}
	
}