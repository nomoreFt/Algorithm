package BAEKJOON.BruteForce.BitMask;

import java.io.*;

public class _14889 {
	static int N,min = Integer.MIN_VALUE;
	static boolean[] visited;
	static int[][] S;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		S = new int[N][N];
		visited = new boolean[N];
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
		int team_start = 0;
		int team_link = 0;
		
		for(int i = 0; i < N-1; i++) {
			for(int j = i+1; j < N; j++) {
				if(visited[i]==true&&visited[j]==true) {
					team_start += S[i][j];
					team_start += S[j][i];
				}
				if(visited[i]==false && visited[j] == false) {
					team_link+=S[i][j];
					team_link+=S[j][i];
				}
			}
		}
		
		int val = Math.abs(team_start-team_link);
		
		if(val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		
		min = Math.min(val, min);
	}
}
