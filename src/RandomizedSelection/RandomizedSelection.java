package RandomizedSelection;

/**
 * @author ºÚ—Ù
 *
 */
public class RandomizedSelection {

	/**
	 * initially (i, j) = (p-1, p)
	 * @param A
	 * @param p
	 * @param r
	 * @return
	 */
	public static int Partition(int[] A, int p, int r) {
		// set A[r] as pivot
		int x = A[r];
		System.out.println(" pivote: "+x);
		int i = p - 1;
		for (int j = p; j <= r; j++) {
			if (A[j] <= x) {
				i++;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		//set pivot in position
		return i+1;
	}

	/**
	 * @param A
	 * @param p
	 * @param r
	 * @return
	 */
	public static int RandomizedPartition(int[] A, int p, int r){
		int j = random(p, r);
		//exchange A[j] and A[r]
		int temp = A[j];
		A[j] = A[r];
		A[r] = temp;
	    Partition(A, p, r);
	    System.out.println();
	    return j;
	}
	
	/**
	 * @param p
	 * @param r
	 * @return
	 */
	public static int random(int p, int r){
		int  q = r-p;
		int randomInt = (int) (Math.random()*q) + p;
		System.out.println("Randomized partition index: " + randomInt
				+ " p: " + p + " r: " + r);
		return randomInt;
	}
}
