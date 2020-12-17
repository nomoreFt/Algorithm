package BAEKJOON.BruteForce.Permutation;

import java.io.*;

public class _10971 {
	static int[][] price;
	static int N;
	static int[] arr;
	static boolean[] visited;
	static int[] output;
	static int min = Integer.MAX_VALUE;
	static int sum;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		price = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			String[] strs = br.readLine().split(" ");
			for(int j = 0 ; j < N; j++) {
				price[i][j] = Integer.parseInt(strs[j]);
			}
		}
		arr = new int[N];
		visited = new boolean[N];
		output = new int[N];
		permutation(arr,visited,output,0);
	}
	public static void permutation(int[] arr, boolean[] visited, int[] output, int depth) {
		if(depth == N) {
			min = Math.min(sum, min);
			return;
		}
		for(int i = 0 ; i < N; i++) {
			if(visited[i]) continue;
			
		}
	}
}
