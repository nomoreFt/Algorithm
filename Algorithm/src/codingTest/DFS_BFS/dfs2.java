package codingTest.DFS_BFS;

import java.io.*;

public class dfs2 {

	static int n,m;
	static int[][] map = new int[1001][1001];
	static int[] nx = {-1,0,1,0};
	static int[] ny = {0,-1,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		for(int i = 0 ; i < n; i++) {
			String[] strs2 = br.readLine().split("");
			for(int j = 0 ; j < m; j++) {
				map[i][j] = Integer.parseInt(strs2[j]);
			}
		}
		int result = 0;
		for(int i = 0 ; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(dfs(i,j)) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
	static boolean dfs(int x, int y) {
		//만약 범위 넘어가면 false
		
		if(x<0 || y<0 || x>=n || y>=m) return false;
		
		if(map[x][y] == 1) return false;
		map[x][y] = 1;
		for(int i = 0; i < 4; i++) {
			int nextX = x + nx[i];
			int nextY = y + ny[i];
			dfs(nextX,nextY);
		}
		return true;
		//1인경우 그냥 return false
	}

}
