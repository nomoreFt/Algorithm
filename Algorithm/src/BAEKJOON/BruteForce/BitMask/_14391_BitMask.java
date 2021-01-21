package BAEKJOON.BruteForce.BitMask;

import java.io.*;

public class _14391_BitMask{
	static int N,M;
	static int Map[][];
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String strs[] = bf.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		Map = new int[N][M];
		for(int i = 0; i < N; i++) {
			strs = bf.readLine().split("");
			for(int j = 0 ; j < M; j++) {
				Map[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		for(int s = 0; s < (1<<N*M); s++) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				int current = 0;
				for(int j = 0 ; j < M; j++) {
					int k = i*M+j;
					if((s & (1 << k)) == 0) {
						current *= 10;
						current += Map[i][j];
					}else {
						sum+=current;
						current = 0;
					}
				}
				sum +=current;
			}
			
			for(int j = 0; j < M; j++) {
				int current = 0;
				for(int i = 0 ; i < N; i++) {
					int k = i*M+j;
					if((s & (1 << k)) != 0) {
						current *= 10;
						current += Map[i][j];
					}else {
						sum+=current;
						current = 0;
					}
				}
				sum += current;
			}
			max = Math.max(sum, max);
		}
		System.out.println(max);
	}
}