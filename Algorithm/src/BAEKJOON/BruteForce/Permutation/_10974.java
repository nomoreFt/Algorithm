package BAEKJOON.BruteForce.Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class _10974 {
	static StringBuilder sb;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		getAllPermutation(arr, n);
		System.out.println(sb.toString());
	}
	public static void getAllPermutation(int[] arr, int n) {
		int splitNum = n;
		
		for(int i = 1; i <= n; i++) {
			if(i == n) sb.append(arr[i]+"\n");
			else sb.append(arr[i]+" ");
		}
		
		for(int i = n; i > 1; i--) {
			if(arr[i-1] < arr[i]) {
				splitNum = i-1;
				break;
			}
		}
		if(splitNum == n) return;

		for(int j = n; j > splitNum; j--) {
			if(arr[splitNum] < arr[j]) {
				arr = swap(arr, splitNum, j);
				break;
			}
		}
		
		for(int k = splitNum+1; k < n; k++) {
			for (int l = k+1; l <= n; l++) {
				if(arr[k] > arr[l]) {
					arr = swap(arr, k, l);
				}
			}
		}
		getAllPermutation(arr,n);
	}
	public static int[] swap(int[] arr,int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		return arr;
	}
}
