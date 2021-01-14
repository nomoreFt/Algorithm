package BAEKJOON.BruteForce.BitMask;

import java.io.*;
//
public class _1182 {
	static int N,S,B = 0,cnt = 0;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = bf.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		S = Integer.parseInt(strs[1]);
		arr = new int[N];
		strs = bf.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		for(int i = 1; i < (1 << N); i++) {
			int sum = 0;
			for(int j = 0; j < N; j ++) {
				if((i & (1 << j)) != 0) sum += arr[j]; 
			}
			if(sum == S) cnt++;
		}
		System.out.println(cnt);
	}
}
/*	static int N,S,cnt = 0;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = bf.readLine().split(" ");
		N =	Integer.parseInt(strs[0]);
		S =	Integer.parseInt(strs[1]);
		arr = new int[N];
		visited = new boolean[N];
		strs = bf.readLine().split(" ");
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		
		for(int i = 0 ; i < N; i++) {
			DFS(i+1,0,0,0);
		}
		System.out.println(cnt);
	}
	public static void DFS(int length,int idx, int depth, int sum) {
		if(depth == length) {
			if(sum == S) cnt++;
			return;
		}
		for(int i = idx ; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			DFS(length,i+1,depth+1,sum+arr[i]);
			visited[i] = false;
		}
	}
}*/
