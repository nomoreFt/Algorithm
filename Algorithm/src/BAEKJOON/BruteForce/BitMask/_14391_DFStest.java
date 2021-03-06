package BAEKJOON.BruteForce.BitMask;

import java.io.*;

public class _14391_DFStest {
	static int N,M,max = Integer.MIN_VALUE;
	static int[][] Map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = bf.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		Map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			strs = bf.readLine().split("");
			for(int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		DFS(0,0);
		System.out.println(max);
	}
	public static void DFS(int row, int col) {
		if(row >= N) {
			sum();
			return;
		}
		if(col >= M) {
			DFS(row+1,0);
			return;
		}
		if(!visited[row][col]) {
			visited[row][col] = true;
			DFS(row,col+1);
			visited[row][col] = false;
			
			DFS(row,col+1);
		}
	}
	public static void sum() {
		int sum = 0;
		for(int i = 0 ; i < N; i++) {
			int cur = 0;
			for(int j = 0 ; j < M; j++) {
				if(visited[i][j]) {
					cur *= 10;
					cur += Map[i][j];
				}else {
					sum+=cur;
					cur = 0;
				}
			}
			sum += cur;
		}
		for(int i = 0 ; i < M; i++) {
			int cur = 0;
			for(int j = 0 ; j < N; j++) {
				if(!visited[j][i]) {
					cur *= 10;
					cur += Map[j][i];
				}else {
					sum += cur;
					cur = 0;
				}
			}
			sum += cur;
		}
		max = Math.max(sum, max);
	}
}
