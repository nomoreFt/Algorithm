package codingTest.Dp;

import java.io.*;

public class 개미전사 {
	static int N;
	static int[] K;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		K = new int[N+1];
		String[] strs = bf.readLine().split(" ");
		for(int i = 1; i <= N; i++) {
			K[i] = Integer.parseInt(strs[i-1]);
		}
		int even = 0;
		int odd = 0;
		for(int i = 1; i <= N; i++) {
			if(i%2 == 0) {
				even += K[i];
			}else {
				odd += K[i];
			}
		}
		System.out.println(Math.max(even,odd));
	}

}
