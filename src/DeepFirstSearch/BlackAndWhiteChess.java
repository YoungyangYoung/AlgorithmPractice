package DeepFirstSearch;

import java.util.Scanner;

public class BlackAndWhiteChess {

	private static int[] chessboard;
	private static int[] record;
	private static int[] visited;
	private static int[] f;
	private static int SIZE;
	private static int time = 0;
	private static int N;
	private static int score = 0;
	private static int MaxScore = 0;
	private static int counter = 0;
	private static boolean flag = false;
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		N = keyboard.nextInt();
		for(int i = 1; i <= N; i++){
			test_main();
		}
	}
	private static void test_main() {
		// TODO Auto-generated method stub
		SIZE = keyboard.nextInt();
		chessboard = new int[SIZE + 1];
		visited = new int[SIZE + 1];
		record = new int[SIZE + 1];
		f = new int[SIZE + 1];

		for(int i = 1; i <= SIZE; i++){
			chessboard[i] = keyboard.nextInt();
			if(chessboard[i] != 0){
				visited[i] = 1;
			}
		}
		DFSVisit(1);
		System.out.println(MaxScore);
		MaxScore = 0;
	}
	private static void DFSVisit(int i) {
		// TODO Auto-generated method stub
		if( i > 3){
			for(int m = 1; m <= SIZE; m++){
				if(chessboard[m] == 1){
					score ++;
				}
			}
			if(score > MaxScore){
				MaxScore = score;
			}
			for(int token: chessboard){
				System.out.print(token + " ");
			}
			System.out.println();
			for(int token: record){
				System.out.print(token + " ");
			}
			System.out.println();
			for(int token: f){
				System.out.print(token + "|");
			}
			System.out.println();
			System.out.println(score + "=================");
			score = 0;
			
			//chessboard = record;
			for(int m =1 ; m <= SIZE; m++){
				chessboard [m] = record[m];
			}
			return;
		}
		for(int j = 1; j <= SIZE; j++){
			if(visited[j] == 0){
				time++;
				chessboard[j] = 1;
				record[j] = 1;
				visited[j] = 1;
				f[j] = time;
				//right
				for(int m = j + 1; m <= SIZE; m++){
					if(visited[m] == 1){ 
						//block emermy's pieces in one side
						if(chessboard[m] == 2){
							counter++;
						}else if(chessboard[m] == 1 && counter > 0){
							//get stuck between  two pieces of player
							flag =true;
							break;
						}
					}else{
						//stop by white blank
						break;
					}
				}
				if(counter == (SIZE - j)){
					for(int m = j + 1; m <= SIZE; m++){
						chessboard[m] = 1;
					}
				}else if(flag){
					for(int m = j + 1; m <= j + counter; m++){
						chessboard[m] = 1;
					}
				}
				//trigger context parameter 
				counter = 0;
				flag = false;
				//left
				for(int m = j - 1; m > 0; m--){
					if(visited[m] == 1){
						//block emermy's pieces in one side
						if(chessboard[m] == 2){
							counter++;
						}else if(chessboard[m] == 1 && counter > 0){
							//get stuck between  two pieces of player
							flag =true;
							break;
						}
					}else{
						//stop by white blank
						break;
					}
				}
				if(counter == (j - 1)){
					for(int m = j - 1; m > 0; m--){
						chessboard[m] = 1;
					}
				}else if(flag){
					for(int m = j - 1; m >= j - counter; m--){
						chessboard[m] = 1;
					}
				}
				//
				counter = 0;
				flag = false;
				int position = whiteChess();
//				for(int m = 1; m <= SIZE; m++){
//					if(visited[m] == 1){
//						System.out.print(chessboard[m] + " ");
//					}else{
//						System.out.print("0 ");
//					}
//				}
//				System.out.println();
				DFSVisit(i + 1);
				visited[j] = 0;
				visited[position] = 0;
				time = time - 2;
			}
		}
		
	}
	private static int whiteChess() {
		// TODO Auto-generated method stub
		int position = 0;
		//white pieces locate in right unit of chess
		for(int i = SIZE; i > 0; i--){
			if(visited[i] == 0){
				time++;
				chessboard[i] = 2;
				record[i] = 2;
				visited[i] = 1;
				f[i] = time;
				//right
				for(int m = i + 1; m <= SIZE; m++){
					if(visited[m] == 1){
						//block emermy's pieces in one side
						if(chessboard[m] == 1){
							counter++;
						}else if(chessboard[m] == 2 && counter > 0){
							//get stuck between  two pieces of player
							flag = true;
							break;
						}
					}else{
						//stop by white blank
						break;
					}
				}
				if(counter == (SIZE - i)){
					for(int m = i + 1; m <= SIZE; m++){
						chessboard[m] = 2;
					}
				}else if(flag){
					for(int m = i + 1; m <= i + counter; m++){
						chessboard[m] = 2;
					}
				}
				//....................right
				//trigger context parameter 
				counter = 0;
				flag = false;
				//left
				for(int m = i - 1; m > 0; m--){
					if(visited[m] == 1){
						//block emermy's pieces in one side
						if(chessboard[m] == 1){
							counter++;
						}else if(chessboard[m] == 2 && counter > 0){
							//get stuck between  two pieces of player
							flag =true;
							break;
						}
					}else{
						//stop by white blank
						break;
					}
				}
				if(counter == (i - 1)){
					for(int m = i - 1; m > 0; m--){
						chessboard[m] = 2;
					}
				}else if(flag){
					for(int m = i - 1; m >= i - counter; m--){
						chessboard[m] = 2;
					}
				}
				//
				counter = 0;
				flag = false;
				//.......................................left
				position = i;
				break;
			}
		}
		return position;
	}
}
