package LeetCode.DFS;

public class NQueenPuzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(totalNQueens(8));

	}

	static int[] board;
	static int count;

	public static int totalNQueens(int n) {
		if (n == 0)
			return 0;
		count = 0;
		board = new int[n + 1];
		int[] visited = new int[n + 1];
		DFSVisit(1, visited);
		return count;
	}

	public static void DFSVisit(int blog, int[] visited) {
		if (blog >= board.length) {
			count++;
			return;
		}

		for (int i = 1; i < visited.length; i++) {
			if (visited[i] == 0 && rule(blog, i)) {
				visited[i] = 1;
				board[blog] = i;
				DFSVisit(blog + 1, visited);
				visited[i] = 0;
			}
		}
	}

	public static boolean rule(int index, int value) {
		for (int i = 1; i < index; i++) {
			if (value - board[i] == index - i || value - board[i] == i - index) {
				return false;
			}
		}
		return true;
	}
}
