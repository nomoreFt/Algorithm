package BAEKJOON.BruteForce.BitMask;

import java.io.*;

public class _14889 {
	static int N,min = Integer.MIN_VALUE;
	static int startSum=0,linkSum=0;
	static boolean[] visited;
	static int[][] S;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		S = new int[N][N];
		for(int i = 0; i < N; i++) {
			String[] strs = bf.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(strs[j]);
			}
		}
		DFS(0,0);
		System.out.println(min);
	}
	public static void DFS(int idx, int depth) {
		if(depth == N/2) {
			valid();
		}
		for(int i = idx ; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			DFS(i+1,depth+1);
			visited[i] = false;
		}
	}
	public static void valid() {
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i]&&visited[j]) {
					startSum+=S[i][j];
				}
			}
		}
	}
}
