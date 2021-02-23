package codingTest.DFS_BFS;

import java.io.*;

public class 음료수얼려먹기 {
	static int n,m;
	static int map[][];
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = bf.readLine().split(" ");
		n = Integer.parseInt(strs[0]);
		m = Integer.parseInt(strs[1]);
		map = new int[n][m];
		for(int i = 0 ; i < n; i ++) {
			String[] strs2 = bf.readLine().split("");
			for(int j = 0 ; j < m; j++) {
				map[i][j] = Integer.parseInt(strs2[j]);
			}
		}
		
		int result = 0;
		for( int i =- 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(dfs(i,j)) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
	static boolean dfs(int x, int y) {
		
		if(x <= -1 || x >= n || y <= -1 || y >= m) {
			return false;
		}
		
		if(map[x][y] == 1) { 
			return false;
		}
		map[x][y] = 1;
		for(int i = 0 ; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			dfs(nextX,nextY);
		}
		return true;
	}
}
