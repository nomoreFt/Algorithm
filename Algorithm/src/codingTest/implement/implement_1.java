package codingTest.implement;

import java.io.*;

public class implement_1 {//L U R D
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static String[] move = {"L","U","R","D"}; 
	static int n,x = 1, y = 1;
	public static void main(String args[]) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		String[] strs = bf.readLine().split(" ");
		int length = strs.length;
		for(int i = 0; i < length; i++) {
			int nextX = -1, nextY = -1;
			for(int j = 0; j < 4; j++) {
				if(strs[i].equals(move[j])) {
					nextX = x + dx[j];
					nextY = y + dy[j];
				}
				if(nextX <1 || nextX > n || nextY <1 || nextY > n) continue;
				
				x = nextX;
				y = nextY;
			}
		}
		System.out.println(y +" "+ x);
	}
}
