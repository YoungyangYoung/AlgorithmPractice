package DeepFirstSearch;

import java.util.Scanner;

public class SearchInfiniteSequence {

	private static long  m = 12; 
	static Scanner keyboard = new Scanner(System.in);
	private static long k;
	private static int b;
	private static int a;
	private static int c;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testcase;
		testcase = keyboard.nextInt();	
		for(int i = 1; i <= testcase; i++ ){
			a = keyboard.nextInt();
			b = keyboard.nextInt();
			c = keyboard.nextInt();
			
			k = keyboard.nextLong();
			long index = search(1, m);
			if(index > 0){
				System.out.println(index);
			}
		}
	}
	
	public static long search(long start, long end){
		
		if(start == end){
			return 0;
		}
		if(sequence(start) == k){
			return start;
		}else if (sequence(end) == k){
			return end;
		}
		
        long value = sequence((start +end) / 2);
		if(value == k){
			return (start+end)/2;
		}else if(value > k){
			return search(start, (start + end)/2);
		}else{
			return search((start +  end)/2 + 1, m);
		}
		
	}
	
	public static long sequence(long n){
	
		return a*n + b*n * log2Int( n) + c * n * n * n; 
	}

	private static int log2Int(long x) {
		// TODO Auto-generated method stub
		if(x == 1)
			return 0;
		else return log2Int(x/2) + 1;
	}

}
