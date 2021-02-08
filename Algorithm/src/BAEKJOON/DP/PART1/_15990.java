package BAEKJOON.DP.PART1;

import java.io.*;

public class _15990 {
	static int n,div,limit;
	static StringBuilder sb = new StringBuilder();
	static int[][] d;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		div = 1000000009;
	
		while(n-- > 0) {
			int x = Integer.parseInt(bf.readLine());
			d = new int[x+1][4];
			int result = 0;
			for(int i = 1; i <= 3; i++) {
				result += dp(x,i)%div;
			} 
			sb.append(result+"\n");
		}
		System.out.println(sb.toString());
	}
	static int dp(int x, int y) {
		if(x==1 && y == 1) return d[1][1]=1;
		if(x==2 && y == 2) return d[2][2]=1;
		if(x==3 && y==1 || y == 2 || y == 3) return d[3][1]=d[3][2]=d[3][3]=1;
		if(d[x][y] != 0) return d[x][y];
		if(y == 1) return d[x][y] = dp(x-1,2) + dp(x-1,3);
		else if(y == 2) return d[x][y] = dp(x-2,1)  +dp(x-2,3);
		else return d[x][y] = dp(x-3,1) + dp(x-3,2);
		
	}
		}
