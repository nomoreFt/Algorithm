package BAEKJOON.BruteForce.BitMask;

import java.io.*;

public class _14391_DFS {
	static int N,M;
	static int Map[][];
	static boolean visited[][];
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String strs[] = bf.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		Map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			strs = bf.readLine().split("");
			for(int j = 0 ; j < M; j++) {
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
		visited[row][col] = true;
		DFS(row,col+1);
		visited[row][col] = false;
		DFS(row,col+1);
	}
	public static void sum() {
		int temp = 0;
		int res = 0;
		for(int i = 0 ; i < N; i++) {
			temp = 0;
			for(int j = 0; j < M; j++) {
				if(visited[i][j]) {
					temp *= 10;
					temp += Map[i][j];
				}else {
					res += temp;
					temp = 0;
				}
			}
			res += temp;
		}
		for(int i = 0; i < M; i++) {
			temp = 0;
			for(int j = 0 ; j < N; j++) {
				if(!visited[j][i]) {
					temp *= 10;
					temp += Map[j][i];
				}else {
					res += temp;
					temp = 0 ;
				}
			}
			res += temp;
		}
		max = Math.max(res,max);
	}
}