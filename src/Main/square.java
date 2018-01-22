package Main;

public class square {
    public static void main(String[] args){
    	if(isPerfectSquare(2147483647)){
    		System.out.println("heheheh");
    	}
    }
    public static boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num = num - i;
            i = i + 2;
        }
        return num == 0;
    }
    
    public static boolean isPerfectSquare1(int num) {
    	 if(num < 1) return false;  
         if(num == 1) return true;  
         int left = 0, right = num/2;  
         while(left <= right)  
         {  
             long mid = (left+right)/2;  
             long val = mid*mid;  
             if(val == num) return true;  
             else if(val > num) right = (int) (mid-1);  
             else left = (int) (mid+1);  
         }  
         return false;  
     }  
    
}
