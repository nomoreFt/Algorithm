package codingTest.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로찾기 {
	static int[][] map = new int[201][201];
	static int n, m;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = bf.readLine().split(" ");
		n = Integer.parseInt(strs[0]);
		m = Integer.parseInt(strs[1]);
		for (int i = 0; i < n; i++) {
			String[] strs2 = bf.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(strs2[j]);
			}
		}
		System.out.println(bfs(0,0));
	}

	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer( new Node(x, y));
		while (!q.isEmpty()) {
			Node node = q.poll();
			x = node.getX();
			y = node.getY();

			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];

				// 미로찾기 공간 벗어난경우 무시
				if (nextX < 0 || n <= nextX || nextY < 0 || nextY >= m)
					continue;
				// 벽인 경우 무시
				if (map[nextX][nextY] == 0)
					continue;
				// 해당 노드 최초방문시에만 최단 거리 기록
				if (map[nextX][nextY] == 1) {
					map[nextX][nextY] = map[x][y] + 1;
					q.offer(new Node(nextX, nextY));
				}
			}
		}
		return map[n - 1][m - 1];
	}
}

	class Node {
	private int x;
	private int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}
