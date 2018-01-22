package POJ;

import java.util.Scanner;

public class Dividing {

	public static void main(String[] args) {

		int[] marbles = new int[6 + 1];
		Scanner keyboard = new Scanner(System.in);
		int count = 0, k = 0;
		while (true) {
			count = 0;
			k ++;
			for (int i = 1; i < marbles.length; i++) {
				marbles[i] = keyboard.nextInt();
				count += marbles[i];
			}
			if (count == 0)
				break;
			if(BalancedDivision(marbles)) {
				System.out.println("Collection #" + k + ":");
				System.out.println("Can be divided.");
			}else {
				System.out.println("Collection #" + k + ":");
				System.out.println("Can't be divided.");
			}
		}
		
		System.out.println("finished");
	}

	public static boolean BalancedDivision(int[] marbles) {
		int sumVal = 0;
		for (int i = 1; i < marbles.length; i++) {
			sumVal += marbles[i] * i;
		}
		if (sumVal % 2 != 0)
			return false;
		int[][] balDivision = new int[6 + 1][(sumVal / 2) + 1];
		for (int i = 1; i < marbles.length; i++) {
			if(marbles[i] > 0) {
				for (int j = 0; j <= sumVal / 2; j++) {
					//the num of item to be selected 
					for(int m = 1; m <= marbles[i]; m++) {
						if (m * i > j) {
							balDivision[i][j] = balDivision[i - 1][j];
							break;
						} else {
							balDivision[i][j] = Math.max(balDivision[i - 1][j], balDivision[i - 1][j - m * i] + m * i);

						}
						if(sumVal / 2 == balDivision[i][j])
							return true;
					}
				}
			}
		}
		return false;
	}
}
