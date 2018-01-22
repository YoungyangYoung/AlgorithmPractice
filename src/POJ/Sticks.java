package POJ;

import java.util.Scanner;

public class Sticks {

	static int[] used;
	static int[] sticks;

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		while (true) {
			int sticksNum = keyboard.nextInt();
			if (sticksNum == 0) {
				break;
			}
			int[] input = new int[sticksNum];
			int sumLength = 0;
			for (int i = 0; i < sticksNum; i++) {
				input[i] = keyboard.nextInt();
				sumLength += input[i];
			}
			sticks = new int[sticksNum];
			used = new int[100];
			mergesort(input, sticks, 0, sticksNum - 1);
			int len = sticks[0];
			for (int i = len; i <= sumLength; i++) {
				if (sumLength % i != 0)
					continue;
				if (concatenate(sticksNum, sticksNum, 0, i)) {
					System.out.println(i);
					break;
				}
			}

		}

	}

	private static boolean concatenate(int totalSticks, int unusedSticks,
			int left, int len) {
		// totalSticks: the number of sticks
		// unusedSticks: unused sticks which have made up sticks in length len
		// left : the remaining length of stick is making up
		// len: length which try to make up
		int i;
		if (unusedSticks == 0 && left == 0)
			return true;
		if (left == 0)
			left = len;
		for (i = 0; i < totalSticks; i++) {
			if (used[i] == 1)
				continue;
			if (sticks[i] > left)
				continue;
			used[i] = 1;
			if (concatenate(totalSticks, unusedSticks - 1, left - sticks[i],
					len))
				return true;
			used[i] = 0;
			// 如果当前尝试的是某个原始木棒中的第一个位置或最后一个位置，
			// 并且导致最终失败，则不必再在这个位置上尝试余下的木棒
			if (sticks[i] == left || left == len)
				break;

		}

		return false;
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
}
