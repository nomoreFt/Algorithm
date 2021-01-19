package BAEKJOON.BruteForce.BitMask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _14889 {
	static int N,min = Integer.MAX_VALUE;
	static int[][] S;
	static boolean[] visited;
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
			}
		}
	}
	
	/*public static void main(String[] args) throws IOException{
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
		DFS(0,0);
		System.out.println(min);
	}
	static void DFS(int idx, int depth) {
		if(depth == N/2) {
			diff();
			return;
		}
		for(int i = idx; i < N; i++) {
			if(!visited[i]) {
			visited[i] = true;
			DFS(idx+1,depth+1);
			visited[i] = false;
			}
		}
	}
	static void diff() {
		int team_start = 0;
		int team_link = 0;
		for(int i = 0; i < N-1; i++) {
			for(int j = i+1; j < N; j++) {
				if(visited[i] == true && visited[j] == true) {
					team_start += S[i][j]; 
					team_start += S[j][i];
				}
				else if(visited[i] == false && visited[j] == false) {
					team_link += S[i][j];
					team_link += S[j][i];
				}
			}
		}
		int dif = Math.abs(team_start - team_link);
		if(dif == 0) {
			System.out.println(dif);
			System.exit(0);
		}
		min = Math.min(min,dif); 
	}*/
}