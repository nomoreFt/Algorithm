package BAEKJOON.BruteForce.N_M;

import java.io.*;

public class _15650 {
	static int[] arr;
	static int[] output;
	static boolean visited[];
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strs = bf.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		arr = new int[N];
		output = new int[M]; 
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		dfs(0,0);
		System.out.println(sb.toString());
	}
	static void dfs(int idx, int depth) {
		if(depth == M) {
			print(output);
			return;
		}
		for(int i = idx; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			output[depth] = arr[i];
			dfs(i+1,depth+1);
			visited[i] = false;
		}
	}
	static void print(int[] output) {
		for(int i = 0 ; i < output.length; i++) {
			sb.append(output[i] + " ");
		}
		sb.append("\n");
	}
	
}
