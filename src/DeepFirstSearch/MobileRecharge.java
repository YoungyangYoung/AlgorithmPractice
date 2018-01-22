package DeepFirstSearch;

import java.util.Scanner;

public class MobileRecharge {
	static Scanner keyboard = new Scanner(System.in);
	static private int  N;
	static private int K = 0;
	static private int turnNum;
	static private int Min = 0;
	static private int[] recharge;
	static private int[] discharge;
	
	static private int[] visited;
	
	private static int counter = 0;
	public static void main(String[] agrs){
		N = keyboard.nextInt();
		for(int i = 0; i < N; i++){
			test_main();
			if(counter == 0){
				System.out.println("#" + i+1  +": -1" );
			}else{
				System.out.println("#" + i+1 +" " + Min );
			}
			counter = 0;
			Min = 0;
		}
	}

	private static void test_main() {
		// TODO Auto-generated method stub
		turnNum = keyboard.nextInt();
		K = keyboard.nextInt();
		recharge = new int[turnNum + 1];
		discharge = new int[turnNum + 1];
		visited = new int[turnNum + 1];
		
		for(int i = 1; i <= turnNum; i++){
			recharge[i] = keyboard.nextInt();
		}
		
		for(int i = 1; i <= turnNum; i++){
			discharge[i] = keyboard.nextInt();
		}
		
		for(int i = 0; i <= K; i++){
			int initialPower = i;
			DFSVisit(1, initialPower, visited, initialPower);
			if(counter > 0){
				if(Min == 0){
					Min = initialPower;
				}else if( Min > initialPower){
					Min = initialPower;
				}
			}
		}
	}

	private static void DFSVisit(int blog, int electricity, int[] visited, int initialPower) {
		if(blog > turnNum){
			counter++;
			return;
		}
		for(int i = 1; i <= turnNum; i++ ){
			if(visited[i] == 0){
				if( electricity + recharge[i] <= K 
						&& electricity + recharge[i] - discharge[i] >= 0) {
					visited[i] = 1;
					electricity = electricity + recharge[i];
					electricity = electricity - discharge[i];
					DFSVisit(blog + 1, electricity, visited, initialPower);
					visited[i] = 0;
					electricity = electricity - recharge[i];
					electricity = electricity + discharge[i];
				}else{
					return;
				}
				
			}
		}
	}
}
