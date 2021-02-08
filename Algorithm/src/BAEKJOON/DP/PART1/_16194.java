package BAEKJOON.DP.PART1;

import java.io.*;

public class _16194 {
	static int N;
	static int[] P,d;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		P = new int[N+1];
		d = new int[N+1];
		String strs[] = bf.readLine().split(" ");
		for(int i = 1 ; i <= N; i++) {
			d[i] = Integer.MAX_VALUE;
			P[i] = Integer.parseInt(strs[i-1]);
		}
		System.out.println(dp(N));
	}
	static int dp(int x) {
		if(x == 0) return 0;
		if(d[x] != Integer.MAX_VALUE) return d[x];
		for(int i = 1; i <= x; i++) {
			d[x] = Math.min(d[x], dp(x-i) + P[i]);
		}
		return d[x];
	}
}
