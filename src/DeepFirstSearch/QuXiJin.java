package DeepFirstSearch;

import java.util.Scanner;

public class QuXiJin {

	static Scanner keyboard = new Scanner(System.in);
	private static int N;
	private static int MinCost;
	private static int[] monster, payment;
    private static int temp1, temp2, temp3;
	public static void main(String[] args){
		int T = keyboard.nextInt();
		for(int i = 1; i <= T; i++){
			test_main(i);
		}
	}
	private static void test_main(int index) {
		// TODO Auto-generated method stub
		N = keyboard.nextInt();
		monster = new int[N + 1];
		payment = new int[N + 1];
		for(int i = 1; i <= N; i++){
			monster[i] = keyboard.nextInt();
			payment[i] = keyboard.nextInt();
		}
		DFSVisit(1, 0, 0, 0, 0 );
		if(MinCost > 0){
			System.out.println("#" + index + " " + MinCost);
		}else{
			System.out.println("No Answer");
		}
		MinCost = 0;
	}
	private static void DFSVisit(int blog, int s1, int s2,
			 int s3, int cost) {
		// TODO Auto-generated method stub
		if(blog > N){
			if(MinCost == 0){
				MinCost = cost;
			}else if(MinCost > cost){
				MinCost = cost;
			}
			return;
		}
		
		
		// pay for travel
		cost = cost + payment[blog];
		DFSVisit(blog + 1, s1, s2, s3, cost);
		cost = cost - payment[blog];
		
		//hire monsters
		cost = cost + payment[blog] * 2;
		//hired monsters with 3 lives increase by num of monster in tribe
		s3 = s3 + monster[blog];
		DFSVisit(blog + 1, s1, s2, s3, cost);
		cost = cost - payment[blog] * 2;
		s3 = s3 - monster[blog];

		//pass by force
		if(s1 >= monster[blog]){
			temp1 = s1;
			temp2 = s2;
			temp3 = s3;
			s3 = 0;
			s2 = temp3;
			s1 = temp2;
			DFSVisit(blog + 1, s1, s2, s3, cost);
			s1 = temp1;
			s2 = temp2;
			s3 = temp3;
		}else if(s1 < monster[blog] && (s1 +s2) > monster[blog]){
			temp1 = s1;
			temp2 = s2;
			temp3 = s3;
			s3 = 0;
			s2 = temp3;
			s1 = temp2 - (monster[blog] - temp1);
			DFSVisit(blog + 1, s1, s2, s3, cost);
			s1 = temp1;
			s2 = temp2;
			s3 = temp3;
		}else if((s1 + s2) < monster[blog] && (s1 + s2 + s3) > monster[blog]){
			temp1 = s1;
			temp2 = s2;
			temp3 = s3;
			s3 = 0;
			s2 = temp3 - (monster[blog] - temp2 - temp1);
			s1 = 0;
			DFSVisit(blog + 1, s1, s2, s3, cost);
			s1 = temp1;
			s2 = temp2;
			s3 = temp3;
		}else{
			return;
		}

	}
}
