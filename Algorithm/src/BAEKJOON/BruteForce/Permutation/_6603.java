package BAEKJOON.BruteForce.Permutation;

import java.io.*;

//
public class _6603 {
	static int N;
	static int arr[];
	static int output[];
	static boolean visited[];
	static int lottoNum = 6;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		while(true) {
			String[] strs = br.readLine().split(" ");
			N = Integer.parseInt(strs[0]);
			if(N == 0) break;
			arr = new int[N];
			output = new int[lottoNum];
			visited = new boolean[N];
			for(int i = 1 ; i <= N; i++) {
				arr[i-1] = Integer.parseInt(strs[i]);
			}
			dfs(0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	public static void dfs(int depth) {
		if(depth == lottoNum) {
			print(output);
			return;
		}
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			output[depth] = arr[i];
			dfs(depth+1);
			visited[i] = false;
		}
	}
	public static void print(int[] output) {
		for(int i = 0 ; i < output.length; i++) {
			if(i == output.length-1) sb.append(output[i]+"\n");
			else sb.append(output[i] + " ");
		}
	}
}