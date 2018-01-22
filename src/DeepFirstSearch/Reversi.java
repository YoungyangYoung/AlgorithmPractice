package DeepFirstSearch;

import java.util.Scanner;

public class Reversi {

	private static int[] chessboard;
	private static int[] record;
	private static int[] visited;
	private static int[] color;
	private static int[] f;
	private static int SIZE;
	private static int time = 0;
	private static int N;
	private static int score = 0;
	private static int MaxScore = 0;
	private static int counter = 0;
	private static boolean flag = true;
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
		f = new int[SIZE + 1];
		color = new int[SIZE + 1];
		record = new int[SIZE + 1];

		for(int i = 1; i <= SIZE; i++){
			chessboard[i] = keyboard.nextInt();
			if(chessboard[i] != 0){
				visited[i] = 1;
				color[i] = -1;
			}
		}
		DFSVisit(1);
		System.out.println(MaxScore + " +++++++++++++++");
		MaxScore = 0;
	}
	private static void DFSVisit(int i) {
		// TODO Auto-generated method stub
		if( i > 3){
			for(int m = 1; m <= SIZE; m++){
				System.out.print(chessboard[m] + " ");
			}
			System.out.println();
			for(int m = 1; m <= SIZE; m++){
				System.out.print(f[m] + "|");
			}
			System.out.println();
			//'''''''''''''''''''''''''''''score
			for(int m =1 ; m <= SIZE; m++){
				record[m] = chessboard [m] ;
				if(color[m] != -1){
					color[m] = 0;
				}
			}
			getScore(1);
			for(int m = 1; m <= SIZE; m++){
				if(record[m] == 1){
					score ++;
				}
			}
			System.out.println("--------------------" + score);
			if(score > MaxScore){
				MaxScore = score;
			}
			
			score = 0;
			return;
		}
		for(int j = 1; j <= SIZE; j++){
			if(visited[j] == 0){
				time++;
				chessboard[j] = 1;
				visited[j] = 1;
				f[j] = time;
				int position = whiteChess();
				DFSVisit(i + 1);
				visited[j] = 0;
				visited[position] = 0;
				f[j] = 0;
				f[position] = 0;
				chessboard[j] = 0;
				chessboard[position] = 0;
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
				visited[i] = 1;
				f[i] = time;
				position = i;
				break;
			}
		}
		return position;
	}
	
	public static void getScore(int index){
		if(index > SIZE){
			for(int m = 1; m <= SIZE; m++){
				System.out.print(record[m] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 1; i <= SIZE; i++){
			if(f[i] == index){
				color[i] = 1;
					//right
					for(int m = i + 1; m <= SIZE; m++){
						if(color[m] == 1 || color[m] == -1){
							//block emermy's pieces in one side
							if(record[m] != chessboard[i]){
								counter++;
							}else if(record[m] == chessboard[i] && counter > 0){
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
							record[m] = chessboard[i];
						}
					}else if(flag){
						for(int m = i + 1; m <= i + counter; m++){
							record[m] = chessboard[i];
						}
					}
					//....................right
					//trigger context parameter 
					counter = 0;
					flag = false;
					//left
					for(int m = i - 1; m > 0; m--){
						if(color[m] == 1 || color[m] == -1){
							//block emermy's pieces in one side
							if(record[m] != chessboard[i]){
								counter++;
							}else if(record[m] == chessboard[i] && counter > 0){
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
							record[m] = chessboard[i];
						}
					}else if(flag){
						for(int m = i - 1; m >= i - counter; m--){
							record[m] = chessboard[i];
						}
					}
					//
					counter = 0;
					flag = false;
				}
		}
		getScore(index + 1);
	}

}
