package Main;

import RandomizedSelection.RandomizedQuickSorter;


public class algorithmsTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2, 8, 7, 1, 3, 5, 6, 4};
		int [] b = RandomizedQuickSorter.RandomizedQuickSort(a, 0, a.length-1);
		System.out.println();
		for(int token: b){
			System.out.print(token + " ");
		}
		System.out.println();
	}

}
