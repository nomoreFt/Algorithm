package BAEKJOON.Collections;

import java.util.*;

public class _2750 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int cnt = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while (cnt-- > 0) {
			arr.add(scan.nextInt());
		}
		Collections.sort(arr);
		for (int val : arr) {
			sb.append(val + "\n");
		}
		System.out.print(sb.toString());
	}

}
