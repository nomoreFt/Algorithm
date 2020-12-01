package BAEKJOON.Math;

import java.io.*;

public class _1934 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (cnt-- > 0) {
			String str[] = br.readLine().split(" ");
			long num1 = Integer.parseInt(str[0]);
			long num2 = Integer.parseInt(str[1]);

			long gcd = getGCD(Math.max(num1, num2), Math.min(num1, num2));
			sb.append((num1 * num2) / gcd + "\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	public static long getGCD(long a, long b) {
		return b == 0 ? a : getGCD(b, a % b);
	}

}
