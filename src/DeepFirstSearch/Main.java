package DeepFirstSearch;

import java.util.Scanner;

public class Main {
	static int SIZE = 11;
	static int[][] A = new int[SIZE][SIZE];
	static Scanner keyboard = new Scanner(System.in);
	static int M;
	int N;
	public static void main(String[] args){
		M = keyboard.nextInt();
		for(int i = 0; i < M; i++){
			for(int j = 0; j < M; j++){
				A[i][j] = keyboard.nextInt();
			}
		}
		
		DFS dfs = new DFS(A);
	}

}
