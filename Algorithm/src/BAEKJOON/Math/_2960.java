package BAEKJOON.Math;

import java.util.Scanner;
public class _2960 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String strs[] = str.split(" ");
		int N = Integer.parseInt(strs[0]);
		int K = Integer.parseInt(strs[1]);
		
		int arr[] = new int[N+1];
		int ans = 0;
		
		for(int i = 2; i <= N; i++) {
			arr[i] = i;
		}
		for(int i = 2; i <= N; i++) {
			if(arr[i]==0) continue;
			for(int j = i; j <= N; j += i) {
				if(arr[j] ==0)continue;
				int temp = arr[j];
				arr[j] = 0;
				ans++;
				if(ans == K) {
					System.out.println(temp);
					return;
				}
			}
		}
	
	}
}
