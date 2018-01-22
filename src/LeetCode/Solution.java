package LeetCode;

public class Solution {
	
	public static void main(String[] args){
		
		String input = "PPALLP";
		if(checkRecord(input)){
			System.out.println("hello world!");
		}
	}

	public static boolean checkRecord(String s) {
        int countA = 0;
        int continousL = 0;
        int charA = 'A';
        int charL = 'L';
        for(int i = 0; i < s.length(); i++){
        	if(s.charAt(i) == charA){
        		countA++;
            	continousL = 0;
            }else if(s.charAt(i) == charL){
            	continousL++;
            }else{
            	continousL = 0;
            }
        	if(countA > 1 || continousL > 2)
        		return false;
        }
        return true;
    }
}
