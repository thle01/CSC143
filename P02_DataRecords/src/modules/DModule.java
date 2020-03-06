package modules;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class DModule {

	public static <T extends Comparable<T>> int binarySearch(List<T> list, T target) {
		int min = 0;
		int max = list.size() - 1;
		while (min <= max) {
			int mid = (min + max) / 2;
			if (list.get(mid).compareTo(target) == 0) {
				return mid;
			} else if (list.get(mid).compareTo(target) < 0) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		return -1;
	}

	public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
		T temp = null;
		for (int i = 0; i < list.size(); i++) { 
			for(int j = 1; j < list.size() - i; j++) { 
				if(list.get(j).compareTo(list.get(j-1)) < 0){
					temp = list.get(j);
					list.set(j, list.get(j-1));
					list.set(j-1, temp );
				}
			}
		}
	}



	public static <T extends Comparable<T>> void insertionSort(List<T> list) {
		T current;
		int j;
		for (int i = 1; i < list.size(); i++) {
			current = list.get(i);
			for (j = i; j > 0 && current.compareTo(list.get(j-1)) < 0; j--) {
				list.set(j, list.get(j-1));
			}
			list.set(j, current);
		}
	}
	
	public static <T extends Comparable<T>> void maxInsertionSort(List<T> list) {
		T current;
		int j;
		for (int i = 1; i < list.size(); i++) {
			current = list.get(i);
			for (j = i; j > 0 && current.compareTo(list.get(j-1)) > 0; j--) {
				list.set(j, list.get(j-1));
			}
			list.set(j, current);
		}
	}
	
	public static <T extends Comparable<T>> void selectionSort(List<T> list, Comparator<T> comp) {
		int minIndex;
		for (int i = 0; i < list.size() - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (comp.compare(list.get(j), list.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(list, minIndex, i);
			}
		}
	}
	
	public static <T> void maxSelectionSort(List<T> list, Comparator<T> comp) {
		int maxIndex;
		for (int i = 0; i < list.size() - 1; i++) {
			maxIndex = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (comp.compare(list.get(j), list.get(maxIndex)) > 0) {
					maxIndex = j;
				}
			}
			if (maxIndex != i) {
				swap(list, maxIndex, i);
			}
		}
	}

	private static <T extends Comparable<T>> void merge(List<T> list, List<T> left, List<T> right) {
		int index = 0;
		int leftIndex = 0;
		int rightIndex = 0;

		while (leftIndex < left.size() && rightIndex < right.size()) {
			if (left.get(leftIndex).compareTo(right.get(rightIndex)) < 0)
				list.set(index++, left.get(leftIndex++));
			else {
				list.set(index++, right.get(rightIndex++));
			}
		}
		while (leftIndex < left.size()) {
			list.set(index++, left.get(leftIndex++));
		}
		while (rightIndex < right.size()) {
			list.set(index++, right.get(rightIndex++));
		}
	}

	public static <T extends Comparable<T>> void mergeSort(List<T> list) {
		if (list.size() > 1) {
			List<T> left = splitFirstHalf(list);
			List<T> right = splitSecondHalf(list);
			mergeSort(left);
			mergeSort(right);
			merge(list, left, right);
		}
	}

	private static <T extends Comparable<T>> int partition(List<T> list, int low, int high) {
		int midpoint = (high + low) / 2;
		T pivot = list.get(midpoint);
		boolean done = false;

		while (!done) {
			while (list.get(low).compareTo(pivot) < 0) {
				++low;
			}
			while (list.get(high).compareTo(pivot) > 0) {
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

	public static <T extends Comparable<T>> void quickSort(List<T> list) {
		quickSort(list, 0, list.size() - 1);
	}

	private static <T extends Comparable<T>> void quickSort(List<T> list, int left, int right) {
		if (left >= right) {
			return;
		}
		int j = partition(list, left, right);
		quickSort(list, left, j);
		quickSort(list, j + 1, right);
	}


	public static <T> List<T> splitFirstHalf(List<T> list) {
		int l = list.size() / 2;
		List<T> firstHalf = new ArrayList<T>();
		for (int i = 0; i < l; i++) {
			firstHalf.add(list.get(i));
		}
		return firstHalf;
	}

	public static <T> List<T> splitSecondHalf(List<T> list) {
		int l = list.size() / 2;
		List<T> secondHalf = new ArrayList<T>();
		for (int i = l, j = 0; i < list.size(); i++, j++) {
			secondHalf.add(list.get(i));
		}
		return secondHalf;
	}

	public static <T> void swap(List<T> list, int a, int b) {
		T temp = list.get(a);
		list.set(a, list.get(b));
		list.set(b, temp);
	}
	
	public static <T> void swap(List<T> list, T a, T b) {
		int _a = list.indexOf(a);
		int _b = list.indexOf(b);
		T temp = list.get(_a);
		list.set(_a, list.get(_b));
		list.set(_b, temp);
	} 

}