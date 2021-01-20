package BAEKJOON.BruteForce.BitMask;

import java.io.*;

public class _14391 {
	static int N,M;
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = bf.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		arr = new int[N][M];
		for(int i = 0 ; i < N; i++) {
			strs = bf.readLine().split("");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
	}

}
