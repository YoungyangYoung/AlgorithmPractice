package DeepFirstSearch;

import java.util.Scanner;

class Node {
	int x;
	int y;
	int step;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class HousePurchase {

	static Scanner keyboard = new Scanner(System.in);
	private static int[][] c1, c2, c3, c4;
	private static int[][] points = new int[5][3];
	private static int[][] map;
	private static Node[] queue;
	private static int[][] next = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	private static int N;

	public static void main(String[] args) {
		int T = keyboard.nextInt();
		for (int i = 1; i <= T; i++) {
			test_main(i);
		}
	}

	private static void test_main(int index) {
		// TODO Auto-generated method stub
		N = keyboard.nextInt();
		int C = keyboard.nextInt();

		c1 = new int[N + 1][N + 1];
		c2 = new int[N + 1][N + 1];
		c3 = new int[N + 1][N + 1];
		c4 = new int[N + 1][N + 1];

		map = new int[N + 1][N + 1];

		for (int i = 1; i <= C; i++) {
			points[i][1] = keyboard.nextInt();
			points[i][2] = keyboard.nextInt();
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = keyboard.nextInt();
			}
		}
		int[][] visited = new int[N + 1][N + 1];
		BFSVisit(points[1][1], points[1][2], visited, c1);
		visited = new int[N + 1][N + 1];
		BFSVisit(points[2][1], points[2][2], visited, c2);
		visited = new int[N + 1][N + 1];
		BFSVisit(points[3][1], points[3][2], visited, c3);
		visited = new int[N + 1][N + 1];
		BFSVisit(points[4][1], points[4][2], visited, c4);

		int sum = 0;
		int min = 0;
		int maxlength = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sum = c1[i][j] + c2[i][j] + c3[i][j] + c4[i][j];
				if (min == 0) {
					min = sum;
				} else if (min > sum && sum > 0) {
					min = sum;
					// find the max value for c1[i][j] .....c4[i][j]
					maxlength = findMax(
							findMax(findMax(c1[i][j], c2[i][j]), c3[i][j]),
							c4[i][j]);
				}
			}
		}
		System.out.println("#" + index + " " + maxlength);
	}

	private static int findMax(int i, int j) {
		// TODO Auto-generated method stub
		if (i > j)
			return i;
		else
			return j;
	}

	private static void BFSVisit(int y, int x, int[][] visited, int[][] c) {
		// TODO Auto-generated method stub
		int front = 0;
		int rear = -1;
		queue = new Node[N * N];
		queue[rear + 1] = new Node(y, x);
		rear++;
		int counter = 0;
		while (rear >= front) {
			Node node = queue[front];
			// find all vertice
			counter++;
			for (int i = 0; i < next.length; i++) {
				int y1 = node.y + next[i][0];
				int x1 = node.x + next[i][1];
				if (y1 > 0 && x1 > 0 && y1 <= N && x1 <= N
						&& visited[y1][x1] == 0 && map[y1][x1] == 1) {
					Node nextone = new Node(y1, x1);
					visited[y1][x1] = 1;
					rear++;
					queue[rear] = nextone;
					c[nextone.y][nextone.x] = counter;
				}
			}
			front++;
		}
	}
}
