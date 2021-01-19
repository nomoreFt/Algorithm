package BAEKJOON.BruteForce.BitMask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _14889 {
	static int N,min = Integer.MAX_VALUE;
	static int[][] S;
	static boolean[] visited;
	static int cnt = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		visited = new boolean[N];
		S = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			for(int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < (1 << N); i++) {
			for(int j = 0; j < N; j++) {
				if((i&(1 << j)) != 0) {
					visited[j] = true;
					cnt ++;
				}
			}
			if(cnt == N/2) {
			getMin();
			}
			for(int k = 0; k < visited.length; k++) {
				visited[k] = false;
			}
			cnt = 0;
		}
		System.out.println(min);
	}
	static void getMin() {
		int team_start = 0;
		int team_link = 0;
		for(int i = 0 ; i < N-1; i++) {
			for(int j = i+1; j < N; j++ ) {
				if(visited[i] && visited[j]) {
					team_start += S[i][j] + S[j][i];
				}
				if(!visited[i] && !visited[j]) {
					team_link += S[i][j] + S[j][i];
				}
		}
	}
		int dif = Math.abs(team_start-team_link);
		if(dif == 0) {
			System.out.println(dif);
			System.exit(0);
		}
		min = Math.min(dif, min);
	}
}