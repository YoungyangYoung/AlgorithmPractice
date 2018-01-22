package DeepFirstSearch;

public class DFS {

	private int SIZE = 11;
	/**
	 * color value represented as:-1: (white)undiscovered, 0: (gray)discovered but not finish processing
	 *  1:(black) finished processing
	 */
	private int[] color = new int[SIZE];
	
	private int[] V = new int[SIZE];
	private char[] vertice = new char[SIZE];
	
	private int[][] A;
	
	private int[] pred = new int[SIZE];
	private int[] d = new int[SIZE];
	private int[] f = new int[SIZE];
	private int[] Low = new int[SIZE];
	
	private int time = 0;
    
	private int[] child = new int[SIZE];
	/**
	 * @param A
	 */
	public DFS(int[][] A){
		
		this.A = A;
		for(int i =0; i < SIZE; i++){
			color[i] = -1;
			pred[i] =  -1;
		}
		
		time = 0;
		for(int i = 0; i < SIZE; i++){
			//start a new tree
			if(color[i] == -1){
				ArtPt(i);
			}
		}
		
		for(int token: Low){
			System.out.print(token + " ");
		}
		System.out.println();
	}

	private void DFSVisit(int i) {
		// TODO Auto-generated method stub
		color[i] = 0;
		d[i] = ++time;
		
		for(int j = 0; j < SIZE; j++){
			if(color[j] == -1 && A[i][j] == 1){
				pred[j] = i;
				DFSVisit(j);
			}
		}
		color[i] = 1;
		f[i] = ++time;
	}
	
	//i stands for v, j stands for w
	public void ArtPt(int i){
		color[i] = 0;
		child[i] = 0;
		//v initially can only climb up to itself
		Low[i] = d[i] = ++time;
		//discover adjacent vertex 
		//for all adj[v] 
		for(int j = 0; j < A.length; j++){
			//count num of child node
			if(A[i][j] == 1 && i < j){
				child[i]++;
			}
			if(color[j] == -1 && A[i][j] == 1){
				pred[j] = i;
				ArtPt(j);
				//if v is the root, apply observation 1
				if(pred[i] == -1){
					//if(w is v's second child then output v)
					if(child[i] >= 2){
//						System.out.println("root " + i);
					}
					//subtree rooted at w can't climb higher than v
				}else if(Low[j] >= d[i]){ // for all Low[j] >=d[i] j->{Adj(i)}
					//apply observation 3
					System.out.println(i + " Child: " + child[i]);
				}
				Low[i] = Math.min(Low[i], Low[j]);
			}else if(j != pred[i] && A[i][j] == 1){
				//(v,w) is a back edge; update Low[v] if a back edge climbs higher
//				if(Low[j] < Low[i])
					Low[i] = Math.min(Low[i], Low[j]);			
				}
		}
		//node discovery has been finished
		color[i] = 1;
	}
}
