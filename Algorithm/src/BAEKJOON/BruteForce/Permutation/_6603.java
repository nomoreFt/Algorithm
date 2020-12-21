package BAEKJOON.BruteForce.Permutation;

import java.io.*;

public class _6603 {
	static int N;
	static int[] arr; 
	static int[] output;
	static int lottoNum = 6;
	static String[] line;
	static StringBuilder sb;
	static boolean visited[];
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		while(true) {
			line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			if(Integer.parseInt(line[0])==0) break;
			arr = new int[N+1];
			for(int i = 1 ; i <=N; i++) {
				arr[i] = Integer.parseInt(line[i]);
			}
			output = new int[N+1];
			visited = new boolean[N+1];
			permutation(arr,output,0,visited);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	public static void permutation(int[] arr, int[] output, int depth, boolean[] visited) {
		if(depth==lottoNum) {
			print(output);
			return;
		}
		for(int i = 1; i <=N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			output[depth] = arr[i];
			permutation(arr,output,depth+1,visited);
			visited[i] = false;
		}
	}
	public static void print(int[] output) {
		for(int i = 1 ; i <= N ; i++) {
			sb.append(output[i] + " ");
		}
		sb.append("\n");
	}
}
