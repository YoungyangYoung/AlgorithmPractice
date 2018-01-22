package maxConteguousSubarr;

/**
 * @author ºÚ—Ù
 * 
 */
public class MCSAlgrithm {

	/**
	 * <p>utilize strategy of divide and conquer. Ai°≠j, i°‹j, separate A into Ai°≠k and Ak+1°≠j,k=(i+j)/2.
	 * There are  three situation where the MCS locates£∫ in right of position k, in left or cross the cut 
	 * 
	 * <p>Complexity £∫O(n log2 n). 
	 * @param A array of {@code int} type
	 * @param i start position
	 * @param j end position
	 * @return maximum contiguous sub-array between i and j
	 */
	public int MCS(int[] A, int i, int j){
		if(i == j){
			return A[i];
		}else{
			int a1 = MCS(A, i, (j + i)/2);
			int a2 = MCS(A, (j + i)/2 + 1, j);
			//find the maximum array cross the i+j/2
			int a3 = middle(A, i, j);
			return Math.max(Math.max(a1, a2), a3);
		}
	}
	
	/**
	 * @param A array of int type
	 * @param i start position
	 * @param j end position
	 * @return the maximum array cross the i+j/2
	 */
	public int middle(int[] A, int i, int j){
		int k = (i + j)/2;
		
		int SUM = A[k];
		int MAX = A[k];
		
		if(i == j){
			return A[i];
		}else{
			for(int m = k + 1; m <= j; m++){
				SUM = SUM + A[m];
				if(SUM > MAX){
					MAX = SUM;
				}
			}
			for(int m = k - 1; m >= i; m--){
				SUM = SUM + A[m];
				if(SUM > MAX){
					MAX = SUM;				}
			}
		}
		return MAX;
	}
	
	/**
	 * find MCS with a for loop.
	 * if sum < 0, reset value of sum to A[i] (i is index of array A where loop visit)
	 * <p>Complexity : O(n) 
	 * @param A an array in type of {@code int}
	 * @return maximum contiguous sub-array
	 */
	public int maxSubArray(int[] A) {
	    int max = 0, sum = 0;
	    for (int i = 0; i < A.length; i++) {
	        if (sum < 0) 
	            sum = A[i];
	        else 
	            sum += A[i];
	        if (sum > max)
	            max = sum;
	    }
	    return max;
	}
	
	


}
