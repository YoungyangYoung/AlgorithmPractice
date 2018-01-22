package DeepFirstSearch;

import java.util.Scanner;

public class RabbitProtection {

	static Scanner keyboard = new Scanner(System.in);
	private static int N;
	private static int spyId;
	private static int MaxId = 0;
	private static int[] IDs;
	private static int[] visited;
    private static int counter = 0;
	public static void main(String[] args){
		
		N = keyboard.nextInt();
		IDs = new int[N + 1];
		visited = new int[N + 1];
		for(int i = 1; i <= N; i++ ){
			IDs[i] = keyboard.nextInt();
		}
		
		for(int i = 2; i < N; i++){
			if(IDs[i - 1] > IDs[i] && IDs[i+1] > IDs[i]){
				spyId = IDs[i];
				counter++;
				if( i > 2){
					
				}
				if(spyId > MaxId){
					MaxId = spyId;
				}
			}
		}
		if(counter == 0){
			System.out.println("no answer");
		}else{
			System.out.println(MaxId);
		}
	}
} 
