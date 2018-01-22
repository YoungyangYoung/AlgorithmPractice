package POJ;

import java.util.Scanner;

/**
 * @author ¼òÑô
 * 
 * web address: http://poj.org/problem?id=1003
 * Date : 2017.5.22
 */
public class Hangover {
	
    static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){
		while(true){
			double input = keyboard.nextDouble();
			if(input == 0){
				break;
			}
			int cardNum = calCards(input);
			System.out.println(cardNum + " card(s)");
		}
	}
	public static int calCards(double input){
		double value = 0;
		int counter = 0;
		double i = 1;
		while(true){
			value = value +  1 / (i + 1);
           counter++;
			if(value >= input){
				return counter;
			}
			i++;
		}
	}
}
