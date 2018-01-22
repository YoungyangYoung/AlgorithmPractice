package DeepFirstSearch;

public class NQueenPuzzle {
	static int SIZE = 5;
	static int[] visited = new int[SIZE];
	static int[] chessboard = new int[SIZE]; 
	static int counter = 0;
	public static void main(String[] args){
		
		DFSVisit(1);
		System.out.println(counter);
	}

	private static void DFSVisit(int i) {
		boolean flag = true;
		// TODO Auto-generated method stub 
//		if(i >= SIZE){
//			return;
//		}
		for(int j = 1; j < SIZE; j++){
			if(visited[j] == 0){
				//slope verification 
				for(int m = 1; m < i; m++){
					if(j == (chessboard[i-m] + m) && i >1){
						flag = false;
					}
				}
				for(int m = 1; m < i; m++){
					if(j == (chessboard[i-m] - m) && i >1){
						flag = false;
					}
				}
				if(flag){
					chessboard[i] = j;
					visited[j] = 1;
					if(i == SIZE-1 ){
						counter++;
						output(chessboard);
						visited[j] = 0;
						return;
					}
					DFSVisit(i+1);
					visited[j] = 0;
				}
				flag = true;		
			}
		}
		
	}
	
	
	public static void output(int[] data){
		for(int token: data){
			System.out.print(token + " ");
		}
		System.out.println();
	}
}
