package codingTest.DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class bfs2 {
	static int n,m;
	static int map[][];
	static int[] nx = {-1,0,1,0};
	static int[] ny = {0,-1,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		n = Integer.parseInt(strs[0]);
		m = Integer.parseInt(strs[1]);
		map = new int[201][201];
		//∏  √ ±‚»≠
		for(int i = 0 ; i < n; i++) {
			String[] strs2 = br.readLine().split("");
			for(int j = 0 ; j < m; j++) {
				map[i][j] = Integer.parseInt(strs2[j]);
			}
		}
		
		System.out.println(bfs(0,0));
	}
	public static int bfs(int x, int y) {
		Queue<Node2> q = new LinkedList<>();
		q.add(new Node2(x,y));
		
		while(!q.isEmpty()) {
			Node2 node2 = q.poll();
			x = node2.getX();
			y = node2.getY();
			for(int i = 0 ; i < 4; i++) {
				int nextX = node2.getX() + nx[i];
				int nextY = node2.getY() + ny[i];
				
				if(nextX<0||nextY<0||nextX>=n||nextY>=m) continue;
				
				if(map[nextX][nextY]==0) continue;
				
				if(map[nextX][nextY]==1) {
					map[nextX][nextY] = map[x][y]+1;
					q.add(new Node2(nextX,nextY));
				}
			}
		}
		return map[n-1][m-1];
	}
}
class Node2{
	private int x;
	private int y;
	public Node2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
