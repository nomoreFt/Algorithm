package codingTest.implement;

import java.io.*;

public class implement_3 {//¿À ¾Æ·¡ ¿Þ À§
	static int[] dx = {1,1,-2,2,-1,-1,-2,+2};
	static int[] dy = {-2,2,-1,-1,-2,+2,1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[9][9];
		String[] str = bf.readLine().split("");
		int x = (str[0].charAt(0)-'a')+1;
		int y = Integer.parseInt(str[1]);
		int ans = 0;
		for(int i = 0 ; i < 8; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			if(validation(nextX,nextY)) ans++;
		}
		System.out.println(ans);
	}
	
	static boolean validation(int x, int y) {
		if(x<1||x>8||y<1||y>8) return false;
		else return true;
	}
}
