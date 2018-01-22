package Main;

public class MergeSort {
	
	public static void main(String[] args){
		int[] nums = {6,67,7,8,9,95,3,22,4,17,13,8,93,54,4};
		int[] sorted = new int[nums.length];
		
		mergesort(nums, 0, nums.length - 1, sorted);
		for(int token: sorted){
			System.out.print(token + " ");
		}
		
	}
	
	public static void mergesort(int[] arr, int start, int end, int[] sorted){
		
		if(start == end){
			return;
		}
		
		int mid = start + ((end - start) / 2);
		mergesort(arr, start, mid, sorted);
		mergesort(arr, mid + 1, end, sorted);
		
		int i = start;
		int j = mid + 1;
		for(int k = start; k <= end; k++){
			if(i <= mid && (j > end ||arr[i] < arr[j])){
				sorted[k] =  arr[i];
				i++;
			}else{
				sorted[k] =  arr[j];
				j++;
			}
		}
		
		for(int k = start; k <= end; k++){
			arr[k] = sorted[k];
		}
		
	}

}
