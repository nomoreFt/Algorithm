package codingTest.implement;

import java.io.*;

public class implement_2 {
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		int cnt = 0;
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= 59; j++) {
				for(int k = 0; k <= 59; k++) {
					if(String.valueOf(i).contains("3")||String.valueOf(j).contains("3")||String.valueOf(k).contains("3")) cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
