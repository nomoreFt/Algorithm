package codingTest.DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class bfs2 {
	static int[][] map = new int[201][201];
	static int n,m;
	static int[] nx = {-1,0,1,0};
	static int[] ny = {0,-1,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		for(int i = 0 ; i < n; i++) {
			String[] strs2 = br.readLine().split("");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(strs2[j]);
			}
		}
		System.out.println(bfs(0,0));
	}
	static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x,y));
		
		while(!q.isEmpty()) {
			Node n2 = q.poll();
			x = n2.getX();
			y = n2.getY();
			
			for(int i = 0 ; i < 4; i++) {
				int nextX = x+nx[i];
				int nextY = y+ny[i];
				
				if(nextX<0||nextY<0||nextX >= n||nextY>=m) {
					continue;
				}
				if(map[nextX][nextY] == 0) continue;
				
				if(map[nextX][nextY] == 1) {
					map[nextX][nextY] = map[x][y]+1;
					q.add(new Node(nextX,nextY));
				}
			}
		}
		return map[n-1][m-1];
		
		
	}
}
