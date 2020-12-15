package BAEKJOON.BruteForce.Permutation;

import java.io.*;
import java.util.Arrays;


public class _10819 {
	static int max;
	static int[] A;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		max = 0;
		A = new int[N+1];
		String[] strs = br.readLine().split(" ");
		for(int i = 1 ; i <= N; i++) {
			A[i] = Integer.parseInt(strs[i-1]);
		}
		Arrays.sort(A);
		getAllPermutation(A,N);
		System.out.println(max);
	}
	public static void getAllPermutation(int[]A, int N) {
		int splitNum = N;
		int temp = 0;
		getMaxSolution(A,N);
		for(int i = N; i > 1; i--) {
			if(A[i-1] < A[i]) {
				splitNum = i-1;
				break;
			}
		}
		if(splitNum == N) return;
		for(int j = N; j > splitNum; j--) {
			if(A[j] > A[splitNum]) {
				A = swap(A,j,splitNum);
				break;
			}
		}
		for(int k = splitNum+1; k < N; k++) {
			for(int l = k+1; l <= N; l++) {
				if(A[k] > A[l]) {
					A = swap(A,k,l);
				}
			}
		}
		/*
		 * for(int a : A) { System.out.print(a + ","); } System.out.println(" = " +
		 * max);
		 */
			getAllPermutation(A,N);
	}
	public static int[] swap(int[] A, int x, int y) {
		int temp = A[x];
		A[x] = A[y];
		A[y] = temp;
		return A;
	}
	public static void getMaxSolution(int[] A, int N) {
		int sum = 0;
		for(int i = 1 ; i < N; i++ ) {
			sum += Math.abs(A[i]-A[i+1]);
		}
		max = Math.max(max, sum);
	}
}
