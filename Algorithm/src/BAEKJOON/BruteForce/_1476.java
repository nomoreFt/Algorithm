package BAEKJOON.BruteForce;

import java.util.Scanner;

public class _1476 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();
		
		int year = 0;
		while(true) {
			year++;
			if((year-a)%15 ==0 && (year-b)%28 == 0 &&  (year-c)%19 == 0) {
				System.out.println(year);
				break;
			}
		}

	}
}
