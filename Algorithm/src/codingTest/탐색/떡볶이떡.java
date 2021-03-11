package codingTest.Å½»ö;

import java.io.*;
import java.util.Arrays;

public class ¶±ººÀÌ¶± {
	static int N, M, H;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		arr = new int[N];
		str = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		Arrays.sort(arr);
		
		int start = 0;
		int end =arr[arr.length-1];
		
		/*
		 * int result = 0; while( start <= end) { long total = 0; int mid = (start +
		 * end) / 2; for(int i = 0 ; i < N; i++) { if(arr[i] > mid) total += arr[i] -
		 * mid; }if(total < M) { end = mid - 1; }else { result = mid; start = mid + 1; }
		 * }
		 */	
		System.out.println(BinarySearch(start,end));
	}									
	public static int BinarySearch(int start, int end) {
		if(start > end ) return -1;
		long total = 0;
		H = (start + end) / 2;
		for(int i = 0 ; i < N; i++) {
			if(arr[i] > H) total += arr[i] - H; 
		}
		if(total == M) {
			return H;
		}else if(total < M){
			return BinarySearch(start, H-1);
		}else return BinarySearch(H+1,end);
		
	}
}
