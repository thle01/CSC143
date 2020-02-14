package modules;

public class RecModule {

	public static int binarySearch(int[] list, int target) {
		return binarySearch(list, target, 0, list.length - 1);
	}

	private static int binarySearch(int[] list, int target, int min, int max) {
		if (max >= min) {
			int mid = min + (max - min) / 2;

			if (list[mid] == target) {
				return mid;
			}

			if (list[mid] > target) {
				return binarySearch(list, target, min, mid - 1);
			}

			return binarySearch(list, target, mid + 1, max);
		}

		return -1;
	}

	public static void selectionSort(int[] list) {
		selectionSort(list, 0); // sort entire data
	}

	private static void selectionSort(int[] list, int start) {
		if (start >= list.length - 1)
			return;
		int minIndex = start;
		for (int index = start + 1; index < list.length; index++) {
			if (list[index] < list[minIndex])
				minIndex = index;
		}
		swap(list, start, minIndex);
		selectionSort(list, start + 1);
	}

	public static void swap(int[] list, int first, int second) {
		int temp = list[first];
		list[first] = list[second];
		list[second] = temp;
	}

}
