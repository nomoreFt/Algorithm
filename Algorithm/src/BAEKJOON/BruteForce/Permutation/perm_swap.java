package BAEKJOON.BruteForce.Permutation;

import java.io.*;

public class perm_swap {
	public static void main(String[] args) throws IOException{
		int n = 3;
		int[] arr = {1,2,3};
		
		permutation(arr, 0, n);
	}
	public static void permutation(int[] arr, int depth, int n) {
		if(depth == n) {
			print(arr,n);
			return;
		}
		for(int i = depth; i < n; i++) {
			swap(arr,depth,i);
			permutation(arr,depth+1,n);
			swap(arr,depth,i);
		}
	}
	public static void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = arr[depth];
	}
	public static void print(int[] arr, int n) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			if(i == n) sb.append(arr[i]);
			else sb.append(arr[i] + " ");
		}
		System.out.println(sb.toString());
	}
}
