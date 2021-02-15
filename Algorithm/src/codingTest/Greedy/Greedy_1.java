package codingTest.Greedy;

import java.io.*;

public class Greedy_1 {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int k = Integer.parseInt(bf.readLine());
		int result = 0;
		while(true) {
			int target = (n/k) * k;
			result += (n-target);
			n = target;
			
			if(n < k) break;
			
			result++;
			n /= k;
		}
		result += (n - 1);
		System.out.println(result);
	}
}
