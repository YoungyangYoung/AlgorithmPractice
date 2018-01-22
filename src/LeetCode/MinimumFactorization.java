package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class MinimumFactorization {

	public static void main(String[] args) {
		int n = 15;
		System.out.println(smallestFactorization(n));
	}

	public static int smallestFactorization1(int a) {
		for (int i = 2; i < a; i++) {
			if (a % i == 0) {
				System.out.println(a / i);
				return i * smallestFactorization(a / i);
			}
		}
		return a;
	}

	public static int min(int a, int b) {
		if (a >= b)
			return b;
		else
			return a;
	}

	public static int smallestFactorization(int n) {
        // Case 1: If number is smaller than 10
        if (n < 10) return n;
        
        // Case 2: Start with 9 and try every possible digit
        List<Integer> res = new ArrayList<>();
        for (int i = 9; i > 1; i--) {
            // If current digit divides n, then store all
            // occurrences of current digit in res
            while (n % i == 0) {
                n = n / i;
                res.add(i);
            }
        }

        // If n could not be broken in form of digits
        if (n != 1) return 0;

        // Get the result from the array in reverse order
        long result = 0;
        for (int i = res.size() - 1; i >= 0; i--) {
            result = result * 10 + res.get(i);
            if (result > Integer.MAX_VALUE) return 0;
        }
        
        return (int)result;
    }
}
