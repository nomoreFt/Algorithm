package codingTest.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 瓤啦利牢拳企备己 {
	static int N,M;
	static int[] arr;
	static int[] d;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		arr = new int[N];
		d = new int[M+1];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.fill(d, 10001);
		d[0] = 0;
		
		for(int i = 0 ; i < N; i++) {
 			for(int j = arr[i]; j <= M; j++) {
				if(d[j - arr[i]] != 10001) {
					d[j] = Math.min(d[j],d[j-arr[i]]+1);
				}
			}
		}
		
		if(d[M] == 10001) System.out.println(-1);
		else System.out.println(d[M]);
		
		
	}
}
