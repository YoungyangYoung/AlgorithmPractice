package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class isHappy {
	
	public static void main(String[] args){
		int n = 33;
		if(isHappy1(n)){
			System.out.println("hello world!");
		}else{
			System.out.println("No no no!");
		}
	}

	public static boolean isHappy1(int n) {
        if(n == 1)
            return true;
        if(n == 0)
            return false;
        
        List<Integer> list = new ArrayList<Integer>();
        while(n != 1){
            int result = 0;
            while(n != 0){
                int  digit = n % 10;
                result = result + digit * digit;
                n = n / 10;
            }
           n = result;
           if(list.contains(n)){
        	   return false;
           }else{
        	   list.add(n);
           }
           if(n == 1){
               return true;
           }
           System.out.println(n);
        }
		return false;
    }
	 public int toInt(int a, int b){
	        String value = String.valueOf(a) + String.valueOf(b);
	        return Integer.parseInt(value);
	    }
}
