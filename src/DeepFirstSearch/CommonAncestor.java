package DeepFirstSearch;

import java.util.Scanner;

public class CommonAncestor {
	
	static int[] cToP;
	static int[][] pToC;
	static int[] visited;
	static int[][] visited2;
	static int V;
	static int count;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++ ){
			V = in.nextInt();
			int E = in.nextInt();
			int A = in.nextInt();
			int B = in.nextInt();
			
			pToC = new int[2][V];
			cToP = new int [V];
			count = 1;
			for(int j = 0; j < V; j++){
				pToC[0][j] = 0;
				pToC[1][j] = 0;
				cToP[j] = 0;
				visited[j] = 0;
				visited2[0][j] = 0;
				visited2[1][j] = 0;
			}
			for(int j = 0; j < E; j++){
				int parent = in.nextInt();
				int child = in.nextInt();
				
				if(pToC[0][parent - 1] == 0)
					pToC[0][parent - 1] = child;
				else
					pToC[1][parent - 1] = child;
				cToP[child -1] = parent;
			}
			int commonNum = getNum(A - 1, B - 1, V);
			getCount(commonNum - 1, V);
		}
	}

	private static void getCount(int n, int V) {
		// TODO Auto-generated method stub
		if(n == 0){
			count = V;
			return;
		}
		if(n >= V){
			return;
		}
		for(int i = 0; i < 2; i++){
			if(pToC[i][n] != 0 && visited2[i][n] == 0){
				int temp = n;
				count ++;
				visited2[i][n] = 1;
				n = pToC[i][n] - 1;
				getCount(n, V);
				visited2[i][n] = 0;
				n = temp;
			}
		}
	}

	private static int getNum(int A, int B, int V) {
		// TODO Auto-generated method stub
		if(A == 0 || B == 0){
			return 1;
		}
		if(A == B){
			return A + 1;
		}
		while(cToP[A] != 0){
			if(visited[B] == 1)
				break;
			B = cToP[B] - 1;
		}
		return B + 1;
	}
}
