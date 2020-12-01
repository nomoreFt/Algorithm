package BAEKJOON.Math;

import java.util.*;

public class _2609 {
	public static int gcd(int a, int b) {
		while (b > 0) {
			int temp = a % b;
			a = b;
			b = temp;

		}
		return a;
	}

	public static int mcd(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String[] strs = str.split(" ");
		int a = Integer.parseInt(strs[0]);
		int b = Integer.parseInt(strs[1]);

		System.out.println(gcd(Math.max(a, b), Math.min(a, b)));
		System.out.println(mcd(a, b));
	}

}
