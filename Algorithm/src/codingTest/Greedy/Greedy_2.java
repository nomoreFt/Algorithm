package codingTest.Greedy;

import java.io.*;

public class Greedy_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String strs[] = bf.readLine().split("");
		int arr[] = new int[strs.length];
		int length = strs.length;
		for(int i = 0 ; i < length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		int result = 0;
		for(int i = 0 ; i < length-1; i++) {
			if(i == 0) {
				result += compare(arr[i],arr[i+1]);
			}else {
				result = compare(result,arr[i+1]);
			}
		}
		System.out.println(result);
	}
	static int compare(int x, int y) {
		return Math.max(x+y, x*y);
	}
}
