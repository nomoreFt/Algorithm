package BAEKJOON.BruteForce.N_M;

import java.io.*;

public class _15652 {
	static int N,M;
	static int arr[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = bf.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		arr = new int[M];
		dfs(0,0);
		System.out.print(sb.toString());
	}
	public static void dfs(int idx, int depth) {
		if(depth == M) {
			for(int val : arr) {
				sb.append(val + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = idx; i < N; i++) {
			arr[depth] = i+1;
			dfs(i,depth+1);
		}
	}
}
