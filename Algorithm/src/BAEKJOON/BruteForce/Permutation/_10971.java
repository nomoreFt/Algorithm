package BAEKJOON.BruteForce.Permutation;

import java.io.*;

//0123 µµ½Ã 
public class _10971 {
	static int[] arr;
	static int[] output;
	static boolean[] visited;
	
	static int[][] price;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		price = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j <N; j++) {
				price[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		arr = new int[N];
		output = new int[N];
		visited = new boolean[N];
		
		for(int i = 0 ; i < N; i++) {
			arr[i] = i;
		}
		permutation(arr,output,visited,0,N);
		System.out.print(min);
	}
	public static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int N) {
		if(depth == N) {
			//getMinPrice(output,N);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			output[depth] = arr[i];
			permutation(arr,output,visited,depth+1,N);
			visited[i] = false;
		}
	}
}
