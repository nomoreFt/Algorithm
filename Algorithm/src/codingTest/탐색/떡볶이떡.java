package codingTest.Å½»ö;

import java.io.*;
import java.util.Arrays;

public class ¶±ººÀÌ¶± {
	static int N, M;
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
		
		int start = 0;
		int end =(int) 1e9;
		
		int result = 0;
		while( start <= end) {
			long total = 0;
			int mid = (start + end) / 2;
			for(int i = 0 ; i < N; i++) {
				if(arr[i] > mid) total += arr[i] - mid;
			}if(total < M) {
				end = mid - 1;
			}else {
				result = mid;
				start = mid + 1;
			}
		}
	}
}
