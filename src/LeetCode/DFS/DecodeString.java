package LeetCode.DFS;
/**
 * @author ºÚ—Ù
 * @Problem No :  394. Decode String
 * {@link} https://leetcode.com/problems/decode-string/description/
 * Date : 2017.10.15
 */
public class DecodeString {
	static int front = -1;
	static String[] stack;
	static int[] val;
	static String result = "";
	private static int front2 = -1;
	public static void main(String[] args) {
		String s = "10[lo]";
		int[] visited = new int[s.length()];
		stack = new String[s.length()];
		val = new int[s.length()];
		decodeString2(s, visited, 0);
//		decodeString2(s, visited, 0);
	}

	public static void decodeString2(String s, int[] visited, int blog) {

		if (blog == s.length() - 1) {
			return;
		}
		int start = 0, end = 0;
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '[' && visited[i] == 0) {
				start = i;
				val[++front2] = num;
				num = 0;
			} else if (s.charAt(i) == ']' && visited[i] == 0) {
				end = i;
				
				String str = reConstruct(getStr(s, start, end, visited), num);
				visited[start] = 1;
				visited[start - 1] = 1;
				visited[i] = 1;
				blog = end;
				decodeString2(s, visited, blog);
			}else if(s.charAt(i) >= 48 && s.charAt(i) <= 57){
				num = num * 10 + (s.charAt(i) - 48);
			}

		}
	}

	public static String reConstruct(String s, int num) {
		String str = "";
		for (int i = 0; i < num; i++) {
			str = str + s;
		}
		return str;
	}

	public static String getStr(String s, int start, int end, int[] visited) {
		String str = "";
		for (int i = start + 1; i < end; i++) {
			if (visited[i] == 0) {
				str = str + s.charAt(i);
				visited[i] = 1;
			}
		}
		return str;
	}

	//
//	public static String decodeString(String s){
//		int[] val = new int[s.length()];
//		String[] stack = new String[s.length()];
//		int front = -1;
//		int front2 = -1;
//		String res = "";
//		int num = 0;
//		for(int i = 0; i < s.length(); i++){
//			if(s.charAt(i) >= 48 && s.charAt(i) <= 57 ){
//				num = num * 10 + (s.charAt(i) - 48);
//			} else if(s.charAt(i) == '['){
//				stack[++front2] = res;
//				val[++front] = num;
//				num = 0;
//				res = "";
//			} else if(s.charAt(i) == ']'){
//				int count = 0;
//				String builder = "";
//				if(front >= 0){
//					count = val[front--];
//				}
//				if(front2 >= 0){
//					builder = stack[front2--];
//				}
//				for (int j = 0; j < count; j++){
//					builder =  builder +  res;
//				}
//				res = builder;
//			}else{
//				res = res + s.charAt(i);
//			}
//		}
//		return res;
//	}
}
