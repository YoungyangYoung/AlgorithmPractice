package RandomizedSelection;

public class RandomizedQuickSorter {

	public static int[] RandomizedQuickSort(int[] A, int p, int r){
		if(p < r){
			int q = RandomizedSelection.RandomizedPartition(A, p, r);
			RandomizedQuickSort(A, p, q - 1);
			RandomizedQuickSort(A, q + 1, r);
		}
		
		return A;
	}
}
