package LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;
/**
 * @author ºÚ—Ù
 * @Problem No :  60. Permutation Sequence
 * {@link} https://leetcode.com/problems/permutation-sequence/description/
 * Date : 2017.10.30
 */
public class PermutationSequence {
	public static void main(String[] args) {
		int n = 3;
		int k = 1;
		System.out.println(getPermutation(n, k));
	}

	public static String getPermutation(int n, int k) {
		int[] arr = new int[n];
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(new Integer(i));
		}
		int i = 0;
		//subtract 1 because of things always starting at 0
		k--;
		while (i < arr.length) {
			int index = k / factor(n - 1);
			arr[i] = list.get(index);
			list.remove(index);
			i++;
			k = k - index * factor(n - 1);
			n--;
		}
		String result = "";
		for (int j = 0; j < arr.length; j++) {
			result = result + arr[j];
		}
		return result;
	}

	public static int factor(int n) {
		int factor = 1;
		for (int i = n; i > 0; i--) {
			factor = factor * i;
		}
		return factor;
	}
	//leetcode answer
	public static String getPermutation1(int n, int k) {
	    List<Integer> numbers = new ArrayList<>();
	    int[] factorial = new int[n+1];
	    StringBuilder sb = new StringBuilder();
	    
	    // create an array of factorial lookup
	    int sum = 1;
	    factorial[0] = 1;
	    for(int i=1; i<=n; i++){
	        sum *= i;
	        factorial[i] = sum;
	    }
	    // factorial[] = {1, 1, 2, 6, 24, ... n!}
	    
	    // create a list of numbers to get indices
	    for(int i=1; i<=n; i++){
	        numbers.add(i);
	    }
	    // numbers = {1, 2, 3, 4}
	    
	    k--;
	    
	    for(int i = 1; i <= n; i++){
	        int index = k/factorial[n-i];
	        sb.append(String.valueOf(numbers.get(index)));
	        numbers.remove(index);
	        k-=index*factorial[n-i];
	    }
	    
	    return String.valueOf(sb);
	}
}
