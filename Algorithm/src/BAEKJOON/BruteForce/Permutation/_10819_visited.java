package BAEKJOON.BruteForce.Permutation;

import java.io.*;
import java.util.Arrays;

public class _10819_visited {
	static int[] arr;
	static int max;
	static boolean visited[];
	static int output[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] strs = br.readLine().split(" ");
		arr = new int[N];
		visited = new boolean[N];
		output = new int[N];
		
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		Arrays.sort(arr);
		
		permutation(arr,0,visited,output,N);
		System.out.print(max);
	}
	public static void permutation(int[] arr, int depth, boolean[] visited, int[] output, int N) {
		if(depth == N) {
			getMaxSolution(output,N);
			return;
		}
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;

			visited[i] = true;
			output[depth] = arr[i];
			permutation(arr,depth+1,visited,output,N);
			visited[i] = false;
		}
	}
	
	public static void getMaxSolution(int[] arr, int N) {
		int sum = 0;
		for(int i = 0; i < N-1; i++) {
			sum += Math.abs(arr[i]-arr[i+1]);
		}
		max = Math.max(sum, max);
	}
}
