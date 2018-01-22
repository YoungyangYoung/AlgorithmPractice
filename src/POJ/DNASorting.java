package POJ;

import java.util.Scanner;

/**
 * @author ºÚ—Ù
 * Problem No: 1007
 * web address: http://poj.org/problem?id=1007
 * Date: 2017.05.22
 */
public class DNASorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		int N = keyboard.nextInt();
		int T = keyboard.nextInt();
		String[] DNAs = new String[T + 1];
		int [] value = new int [T + 1];
		for(int i = 1; i <= T; i++){
			DNAs[i] = keyboard.next();
		}
		for(int i = 1; i <= T; i++){
			value[i] = calStrValue(DNAs[i]);
		}
		
		sort(DNAs, value);
		
		for(int i = 1; i <= T; i++){
			System.out.println(DNAs[i]);
		}

	}

	private static void sort(String[] DNAs, int[] value) {
		// TODO Auto-generated method stub
		String tempStr = null;
		int temp;
		for(int i = 1; i < value.length; i++){
			for(int j = 1; j < DNAs.length; j++ ){
				if(value[i] < value[j]){
					temp = value[i];
					value[i] = value[j];
					value[j] = temp;
					tempStr = DNAs[i];
					DNAs[i] = DNAs[j];
					DNAs[j] = tempStr;
				}
			}
		}
		
	}

	private static int calStrValue(String str) {
		// TODO Auto-generated method stub
		char[] charArr = str.toCharArray();
		int value = 0;
		for(int i = 0; i < charArr.length; i++){
			for(int j = i + 1; j < charArr.length; j++){
				if(charArr[i] > charArr[j]){
					value++;
				}
			}
		}
		return value;
	}

}
