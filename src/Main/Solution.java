package Main;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static int[] numbers;
    private static List<Integer> list = new ArrayList<Integer>(); 
    
    public static void main(String[] args){
    	int[] nums = {10,2,5,10,9,1,1,4,3,7};
    	List<Integer> list1 = findDuplicates(nums);
    	for(int i = 0 ; i < list1.size(); i++){
    		System.out.println(list1.get(i));
    	}
    }
    
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
    
    public static void DFSVisit(int blog, int[] visited){
        if(blog >= numbers.length){
            return;
        }
        if(visited[blog] == 0){
            visited[blog] = 1;
            int counter = 1;
            for(int i = blog + 1; i < numbers.length; i++){
                if(visited[i] == 0){
                    if(numbers[i] == numbers[blog]){
                    	visited[i] = 1;
                        counter ++;
                    }
                }
            }
            if(counter == 2){
            	System.out.println(numbers[blog]);
                list.add(numbers[blog]);
            }
        }
        DFSVisit(blog + 1, visited);
    }
}