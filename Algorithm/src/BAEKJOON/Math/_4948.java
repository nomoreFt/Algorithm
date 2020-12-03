package BAEKJOON.Math;

import java.io.*;
import java.util.*;

public class _4948 {
	
	public static boolean isPrimeNum(int num) {
		if(num==1) return true;
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num%i != 0) continue;
			else return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			arr.add(n);
		}
			for(int i = 0; i < arr.size(); i++) {
				int cnt = 0;
				int n = arr.get(i);
				for(int j = n+1; j <= 2*n; j++ ) {
					if(isPrimeNum(j)) cnt++;
				}
				sb.append(cnt+"\n");
				
			}
		System.out.println(sb.toString());
	}
	
}
