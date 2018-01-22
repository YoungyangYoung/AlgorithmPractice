package Main;

public class DP {
	
	public static void main(String[] args){
		int W = 10;
		int n = 4;
		int[] w = {0, 5, 4, 6, 3};
		int[] v = {0, 10, 40, 30, 50};
		
		int V = KnapsackSR(v, w, n, W);
//		for(int i = 0; i < V.length; i++){
//			for(int j =0; j < V[0].length; j++){
//				System.out.print(V[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(V);
		
	}

	public static int[][] KnapSack(int[] v, int[] w, int n, int W){
		int[][] V = new int[v.length][W + 1];
		
		for(int i = 1; i <= n; i++){
			for(int j = 0; j <= W; j++){
				if(j >= w[i]){
					V[i][j] = Math.max(V[i - 1][j], v[i] + V[i - 1][j - w[i]]);
				}else{
					V[i][j] = V[i - 1][j];
				}
			}
		}
		
		return V;
	}
	
	public static int KnapsackSR(int[] v, int[] w, int n, int W){
		if(n == 0)
			return 0;
		if(W <= 0)
			return Integer.MIN_VALUE;
		int V1 = KnapsackSR(v, w, n-1, W);
		int V2 = KnapsackSR(v, w, n-1, W - w[n]);
		System.out.println(V1 + " " + V2 + " " + W +  " " + w[n]);
		return Math.max(V1,  v[n] + V2);
	}
	
	
}
