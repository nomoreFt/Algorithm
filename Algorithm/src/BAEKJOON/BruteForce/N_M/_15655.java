package BAEKJOON.BruteForce.N_M;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _15655 {
	static int N,M;
	static int[] arr,output;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = bf.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		arr = new int[N];
		visited = new boolean[N];
		output = new int[M];
		strs = bf.readLine().split(" ");
		for(int i = 0 ; i < strs.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		Arrays.sort(arr);
		dfs(0,0);
		System.out.print(sb.toString());
	}
	public static void dfs(int idx, int depth) {
		if(depth == M) {
			for(int val : output) {
				sb.append(val+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = idx; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			output[depth] = arr[i];
			dfs(i,depth+1);
			visited[i] = false;
		}
	}
}
