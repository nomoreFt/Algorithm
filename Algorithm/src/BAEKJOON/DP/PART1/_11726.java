package BAEKJOON.DP.PART1;

import java.io.*;

public class _11726 {
	static int n;
	static int[] d;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		n = Integer.parseInt(br.readLine());
		d = new int[1001];
		System.out.println(dp(n));
	}
	static int dp(int x) {
		if(x ==1) return 1;
		if(x ==2) return 2;
		if(d[x] != 0) return d[x];
		return d[x] = (dp(x-1) + dp(x-2)) % 10007;
	}
}
