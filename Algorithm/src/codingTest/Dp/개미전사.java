package codingTest.Dp;

import java.io.*;
//
public class 개미전사 {
	static int N;
	static int[] K;
	public static int[] d = new int[100];
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		K = new int[N];
		String[] strs = bf.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			K[i] = Integer.parseInt(strs[i]);
		}
		
		d[0] = K[0];
		d[1] = Math.max(K[0], K[1]);
		for(int i = 2; i < N; i++) {
			d[i] = Math.max(K[i-1], K[i-2]+K[i]);
		}
		System.out.println(d[N-1]);
	}

}
