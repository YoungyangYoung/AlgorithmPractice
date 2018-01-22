/**
 * 
 */
package LeetCode;

/**
 * @author ºÚ—Ù
 *
 */
public class CountBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num =  9;
		int output = hammingWeight(num);

			System.out.print(output + " ");

	}

	public static int[] countBits(int num) {
		int[] f = new int[num + 1];
		for (int i = 1; i <= num; i++)
			f[i] = f[i / 2] + (i % 2);
		return f;
	}

	 public static int hammingWeight(int n) {
		 int a = absolute(n);
	        int counter = 0;
	        while(a != 0){
	            if((a & 1) == 1){
	                counter++;
	            }
	           a = a >> 1;
	        }
	        return counter;
	    }
	    
	    public static int absolute(int n){
	        if(n >= 0)
	            return n;
	        else
	            return -n;
	    }
}
