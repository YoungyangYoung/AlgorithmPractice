package PolynomialMultiplication;

public class PolynomialMultipli {

	public int[] PolyMulti(int[] A, int[] B){
		int n = A.length;
		
		int[] a0 = new int[(n/2)-1];
		int[] b0 = new int[(n/2)-1];
		for(int i = 0; i <= (n/2)-1; i++){
			a0[i] = A[i];
			b0[i] = B[i];
		}
		int[] a2 = new int[n/2];
		int[] b2 = new int[n/2];
		for(int i = (n/2); i < n; i++){
			int j = 0;
			a2[j] = A[i];
			b2[j] = B[i];
			j++;
		}
		
		return null;
	}
}
