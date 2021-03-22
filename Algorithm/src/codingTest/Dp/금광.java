package codingTest.Dp;

import java.io.*;

public class ±İ±¤ {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		while(T-- > 0) {
			String[] strs = bf.readLine().split(" ");
			int n = Integer.parseInt(strs[0]);
			int m = Integer.parseInt(strs[1]);
			int[][] map = new int[n][m];
			int[][] dp = new int[n][m];
			int cnt = 0;
			strs = bf.readLine().split(" ");
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(strs[cnt++]);
					dp[i][j] = map[i][j];
				}
			}
			
			for(int j = 1; j < m; j++) {
				for(int i = 0; i < n; i++) {
					int leftUp, left, leftDown;
					//¿ŞÁ· À§ 
					if(i == 0) leftUp = 0;
					else {
						leftUp = dp[i-1][j-1];
					}
					//¿ŞÂÊ
					left = dp[i][j-1];
					//¿ŞÂÊ ¾Æ·¡ 
					if(i == n-1) leftDown = 0;
					else {
						leftDown = dp[i+1][j-1];
					}
					dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(left, leftDown));
						
				}
			}
			int result = 0;
			for(int i = 0; i < n; i++) {
				result = Math.max(result,dp[i][m-1]);
			}
			System.out.println(result);
		}
		
	}

}
