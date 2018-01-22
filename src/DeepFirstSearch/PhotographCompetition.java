package DeepFirstSearch;

import java.util.Scanner;

public class PhotographCompetition {
	static Scanner keyboard = new Scanner(System.in);
	static private int[] votes;
	static private int voterNum;
	static private int N;
	private static int[] visited;
	private static int counter;
	private static int champion = 0;
	public static void main(String[] args){
		N = keyboard.nextInt();
		for(int i = 1; i <= N; i++){
			test_main();
			System.out.println("# " + i + " " + champion);
			champion = 0;
		}
	}
	private static void test_main() {
		// TODO Auto-generated method stub
		voterNum = keyboard.nextInt();
		votes = new int[voterNum + 1];
		visited = new int[voterNum + 1];
		for(int i = 1; i <= voterNum; i++){
			votes[i] = keyboard.nextInt();
		}
		DFSVisit(1);
	} 
	
	public static void DFSVisit(int i){
		if(i > voterNum){
			return;
		}
		
		if(visited[i] == 0){
			for(int j = i; j <= voterNum; j++){
				if(visited[j] == 0){
					if(votes[i] == votes[j]){
						visited[j] = 1;
						counter ++;
					}
				}
			}
			if(counter > (voterNum/2)){
				champion = votes[i];
				return;
			}
			counter = 0;
			DFSVisit(i + 1);
		}
	} 
}
