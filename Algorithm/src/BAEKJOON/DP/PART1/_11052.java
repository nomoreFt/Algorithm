package BAEKJOON.DP.PART1;

import java.io.*;

public class _11052 {
	static int N;
	static int[] d;
	static int[] P;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		d = new int[N+1];
		P = new int[N+1];
		String[] strs = bf.readLine().split(" ");
		for(int i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(strs[i-1]);
		}
		System.out.println(dp(N));
	}
	static int dp(int x) {
		if(x == 1) return P[1];
		if(x == 2) return Math.max(P[2], dp(1)*2);
		if(d[x] != 0) return d[x];
		int result = 0;
		for(int i = 1; i < x; i++) {
			d[x] = Math.max(P[x], dp(x-i) + dp(i));
	}
		return d[x];
	}
}
