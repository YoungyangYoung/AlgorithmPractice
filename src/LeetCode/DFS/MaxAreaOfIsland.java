package LeetCode.DFS;

public class MaxAreaOfIsland {

	static int counter = 0;

	public static void main(String[] args) {

		int[][] grid = new int[][] {{0,1},{1,1}};
//				{ { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
//				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
//				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
//				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
//				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
//				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
//				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
//				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		System.out.println(maxAreaOfIsland(grid));
	}

	public static int maxAreaOfIsland(int[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int max = 0;
		int[][] visited = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (visited[i][j] == 0 && grid[i][j] == 1) {
					DFSVisit(visited, grid, i, j);
				}
				max = Math.max(max, counter);
				counter = 0;
			}
		}
		return max;
	}

	private static void DFSVisit(int[][] visited, int[][] grid, int i, int j) {
		// TODO Auto-generated method stub
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length
				|| grid[i][j] == 0 || visited[i][j] == 1) {
			return;
		}
		counter++;
		visited[i][j] = 1;
		DFSVisit(visited, grid, i + 1, j);
		DFSVisit(visited, grid, i - 1, j);
		DFSVisit(visited, grid, i, j + 1);
		DFSVisit(visited, grid, i, j - 1);

	}

}
