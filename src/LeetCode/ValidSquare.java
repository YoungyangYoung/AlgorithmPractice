package LeetCode;

import java.util.Arrays;
/**
 * @author ¼òÑô
 * @Problem No : 593. Valid Square
 * {@link} https://leetcode.com/problems/valid-square/solution/
 * Date : 2017.09.10
 */
public class ValidSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p1 = { 1, 1 };
		int[] p2 = { 5, 3 };
		int[] p3 = { 3, 5 };
		int[] p4 = { 7, 7 };

		if (validSquare1(p1, p2, p3, p4))
			System.out.println("true");
		else
			System.out.println("false");
	}

	// public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4)
	// {
	// int a = 0, b = 0, c = 0;
	// a = getSlopSquare(p1, p2);
	// b = getSlopSquare(p1, p3);
	// c = getSlopSquare(p1, p4);
	// d = getSlopS
	//
	// if((a == (b + c)|| b == (a + c)|| c == (a + b))&&)
	// return true;
	// else
	// return false;
	// }

	public static boolean validSquare1(int[] p1, int[] p2, int[] p3, int[] p4) {
		if (check(p1, p2, p3, p4) || check(p1, p2, p4, p3)
				|| check(p1, p3, p2, p4))
			return true;
		else
			return false;
	}

	public static boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
		//square has four edges with equal length as well as two diagonals(rhombus not)
		return getSlopSquare(p1, p2) > 0
				&& getSlopSquare(p1, p2) == getSlopSquare(p2, p3)
				&& getSlopSquare(p2, p3) == getSlopSquare(p3, p4)
				&& getSlopSquare(p3, p4) == getSlopSquare(p1, p4)
                && getSlopSquare(p1, p3) == getSlopSquare(p2, p4);
	}

	public double dist(int[] p1, int[] p2) {
		return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0])
				* (p2[0] - p1[0]);
	}

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		int[][] p = { p1, p2, p3, p4 };
		Arrays.sort(p, (l1, l2) -> l2[0] == l1[0] ? l1[1] - l2[1] : l1[0]
				- l2[0]);
		return dist(p[0], p[1]) != 0 && dist(p[0], p[1]) == dist(p[1], p[3])
				&& dist(p[1], p[3]) == dist(p[3], p[2])
				&& dist(p[3], p[2]) == dist(p[2], p[0])
				&& dist(p[0], p[3]) == dist(p[1], p[2]);
	}

	public static int getSlopSquare(int[] a, int[] b) {
		return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
	}

	public static int[] getVector(int[] x, int[] y) {
		return new int[] { x[0] - y[0], x[1] - y[1] };
	}

	public static boolean isVertical(int[] a, int[] b) {
		return a[0] * a[1] + b[0] * b[1] == 0;
	}
}
