package BAEKJOON.DP.PART1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15990{
	static int T,n,div,limit;
	static int[][] d;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        div = 1000000009; 
        limit = 100000;
        T = Integer.parseInt(bf.readLine().trim());
		d = new int [limit+1][4];
		d[1][1] = d[2][2] = d[3][1] = d[3][2] = d[3][3] = 1;
		for(int i = 4; i <= limit; i++) {
			for(int j = 1; j <= 3; j++) {
				if(j == 1) d[i][1] = d[i-1][2] + d[i-1][3]; 
				else if (j == 2) d[i][2] = d[i-2][1] + d[i-2][3];
				else d[i][j] = d[i-3][3] + d[i-3][2];
				d[i][j] %= div;
			}
		}
		for(int tc = 1; tc <= T; tc++){
			n = Integer.parseInt(bf.readLine().trim());
			int result = 0;
			for(int i = 1; i <= 3; i++) {
				result += d[n][i];
                result %= div;
			}
			sb.append(result+"\n");
		}
		System.out.println(sb.toString());
	}
}