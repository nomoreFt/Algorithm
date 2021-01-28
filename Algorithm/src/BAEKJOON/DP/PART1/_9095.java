package BAEKJOON.DP.PART1;

import java.io.*;

public class _9095 {
	static StringBuilder sb = new StringBuilder();
	static int[] d;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		d = new int[11];
		while(T-- > 0) {
			int n = Integer.parseInt(bf.readLine());
			sb.append(dp(n)+"\n");
		}
		System.out.println(sb.toString());
	}
	static int dp(int x) {
		if(x == 1) return 1;
		if(x == 2) return 2;
		if(x == 3) return 4;
		if(d[x] != 0) return d[x];
		return d[x] = dp(x-1) + dp(x-2) + dp(x-3);
	}
}
