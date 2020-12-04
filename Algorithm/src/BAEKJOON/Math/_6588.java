package BAEKJOON.Math;

import java.io.*;
import java.util.*;

public class _6588 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int N = 1000000;
		boolean[] b = new boolean[N+1];
		List<Integer> list = new ArrayList<>();
		
		Arrays.fill(b, true);
		
		for(int i = 3; i*i <= N; i+=2) {
			if(b[i]) {
				for(int j = i*i; j <= N; j+=i) {
					b[j] = false;
				}
			}
		}
		for(int i = 3; i <= N; i+=2) {
			if(b[i]) list.add(i);
		}
		
		while(true) {
			int val = Integer.parseInt(br.readLine());
			if(val == 0) break;
			boolean isWrong = true;
			
			for( int i = 0; i < list.size(); i++) {
				if(b[val-(list.get(i))]) {
					String str = String.valueOf(val) + " = " + String.valueOf(list.get(i)) + " + " + String.valueOf(val-list.get(i))+"\n";
					sb.append(str);
					isWrong = false;
					break;
				}
			}
			if(isWrong) {
				sb.append("Goldbach's conjecture is wrong.");
			}
		}
		System.out.println(sb.toString());
		
}

}