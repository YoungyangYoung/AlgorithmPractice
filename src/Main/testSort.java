package Main;

public class testSort {

	public static void main(String[] args) {
		int[] arr = new int[20];
		int[] work;
		for (int i = 0; i < 100; i++) {

			for (int j = 0; j < 20; j++) {
				arr[j] = (int) ((Math.random() * 10 * Math.random() * 10) * (Math
						.random() * 10 * Math.random() * 10));
			}
			work = new int[20];
			mergesort(arr, work, 0, arr.length - 1);
			for (int token : work) {
				System.out.print(token + " ");
			}
			if (!check(work)) {
				System.out.print("wrong");
			}
			System.out.println();
		}
	}

	public static void mergesort(int[] arr, int[] result, int start, int end) {
		if (start == end)
			return;
		int mid = (start + end) / 2;
		mergesort(arr, result, start, mid);
		mergesort(arr, result, mid + 1, end);
		// merge two sorted sub array
		int i = start;
		int j = mid + 1;
		for (int m = start; m <= end; m++) {
			if (j <= end && (arr[i] < arr[j] || i > mid)) {
				result[m] = arr[j];
				j++;
			} else {
				result[m] = arr[i];
				i++;
			}
		}
		// copy sorted results to original array
		for (int m = start; m <= end; m++) {
			arr[m] = result[m];
		}
	}

	public static boolean check(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1])
				return false;
		}

		return true;
	}
}
