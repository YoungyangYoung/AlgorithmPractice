package LeetCode.DP;

public class IsSubsequence {

	public static void main(String[] args){
		String s = "abc";
		String t = "ahbgdc";
		if(isSubsequence(s, t)){
			System.out.println("heheh");
		}
	}
	public static boolean isSubsequence(String s, String t) {

		if(s.length() > t.length() || s == null || t == null)
			return false;
		char[] origin = s.toCharArray();
		char[] str = t.toCharArray();
		int index = 0;
		for(int i = 0; i < str.length; i++){
			if(str[i] == origin[index]){
				index ++;
			}
			if(index == s.length()){
				System.out.println(index);
				return true;
			}
				
		}
		return false;
	}
}
