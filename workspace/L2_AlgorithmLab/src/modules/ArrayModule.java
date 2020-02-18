package modules;

public class ArrayModule {

	public static int binarySearch(int[] list, int target) {
		int min = 0;
		int max = list.length - 1;
		int mid;
		while (min <= max) {
			mid = (min + max) / 2;
			if (list[mid] == target) {
				return mid;
			} else if (list[mid] < target) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		return -1;
	}

	public static void bubbleSort(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = 0; j < list.length - i - 1; j++) {
				if (list[j] > list[j + 1]) {
					swap(list, j + 1, j);
				}
			}
		}
	}

	public static boolean contains(int[] list, int target) {
		for (int i : list) {
			if (i == target)
				return true;
		}
		return false;
	}

	public static int indexOf(int[] list, int target) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] == target)
				return i;
		}
		return -1;
	}

	public static void insertionSort(int[] list) {    
	  	for (int i = 1; i < list.length; i++) {
	  		int j = i;
	 		while (j > 0 && list[j] < list[j - 1]) {
				swap(list,j,j-1);
				j--;
	 		}
  		}
	}

	private static void merge(int[] list, int[] firstHalf, int[] secondHalf) {
		int index = 0;
		int leftIndex = 0;
		int rightIndex = 0;

		while (leftIndex < firstHalf.length && rightIndex < secondHalf.length) {
			if (firstHalf[leftIndex] < secondHalf[rightIndex])
				list[index++] = firstHalf[leftIndex++];
			else {
				list[index++] = secondHalf[rightIndex++];
			}
		}
		while (leftIndex < firstHalf.length) {
			list[index++] = firstHalf[leftIndex++];
		}
		while (rightIndex < secondHalf.length) {
			list[index++] = secondHalf[rightIndex++];
		}
	}

	public static void mergeSort(int[] list) {
		if (list.length > 1) {
			int[] left = splitFirstHalf(list);
			int[] right = splitSecondHalf(list);
			mergeSort(left);
			mergeSort(right);
			merge(list, left, right);
		}
	}

	private static int partition(int[] list, int low, int high) {
		int midpoint = low + (high - low) / 2;
		int pivot = list[midpoint];
		boolean done = false;

		while (!done) {
			while (list[low] < pivot) {
				++low;
			}
			while (pivot < list[high]) {
				--high;
			}
			if (low >= high) {
				done = true;
			} else {
				swap(list, low, high);
				++low;
				--high;
			}
		}
		return high;
	}

	public static void quickSort(int[] list) {
		quickSort(list, 0, list.length - 1);
	}

	private static void quickSort(int[] list, int left, int right) {
		partition(list, 0, 0);
		int j;
		if (left >= right) {
			return;
		}
		j = partition(list, left, right);
		quickSort(list, left, j);
		quickSort(list, j + 1, right);
	}

	public static void selectionSort(int[] list) {
		int minIndex;
		for (int i = 0; i < list.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < list.length; j++) {
				if (list[j] < list[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(list, minIndex, i);
			}
		}
	}

	private static int[] splitFirstHalf(int[] list) {
		int l = list.length / 2;
		int[] firstHalf = new int[l];
		for (int i = 0; i < l; i++) {
			firstHalf[i] = list[i];
		}
		return firstHalf;
	}

	private static int[] splitSecondHalf(int[] list) {
		int l = list.length / 2;
		int[] secondHalf = new int[list.length - l];
		for (int i = l, j = 0; i < list.length; i++, j++) {
			secondHalf[j] = list[i];
		}
		return secondHalf;
	}

	public static void swap(int[] list, int first, int second) {
		int temp = list[first];
		list[first] = list[second];
		list[second] = temp;
	}

}
