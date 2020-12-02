package BAEKJOON.Math;
//Math
import java.io.*;

public class _9613 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		while (cnt-- > 0) {
			long ans = 0;
			String strs[] = bf.readLine().split(" ");
			long nums[] = new long[strs.length];
			for (int i = 0; i < strs.length; i++) {
				nums[i] = Long.parseLong(strs[i]);
			}
			for (int i = 1; i < strs.length; i++) {
				for (int j = i + 1; j < strs.length; j++) {
					ans += getGCD(Math.max(nums[i], nums[j]), Math.min(nums[i], nums[j]));
				}
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb.toString());
		bf.close();
	}

	public static long getGCD(long a, long b) {
		while (b > 0) {
			long temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
}
