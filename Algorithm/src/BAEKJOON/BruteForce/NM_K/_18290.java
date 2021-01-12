package BAEKJOON.BruteForce.NM_K;
//
import java.io.*;

public class _18290 {
	static int N,M,K;
	static BufferedReader br;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int max;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		K = Integer.parseInt(str[2]);
		arr = new int[N][M];
		visited = new boolean[N][M];
		max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for(int j = 0 ; j < M; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		DFS(0,0);
		System.out.println(max);
	}
	
	public static void DFS(int depth, int sum) {
		
		if(depth==K) {
			max = Math.max(max, sum);
			return;
		}
		for(int i =  0; i < N; i++) {
			for(int j = 0 ; j < M; j++) {
				if(checkValid(i,j)) continue;
				visited[i][j] = true;
				DFS(depth+1,sum+arr[i][j]);
				visited[i][j] = false;
			}
		}
	}
	
	public static boolean checkValid(int x, int y) {
		boolean isOkay = false;
		if(visited[x][y]) return true;
		for(int i = 0; i < 4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			if(nextX<0||nextX>=N||nextY<0||nextY>=M) continue;
			if(visited[nextX][nextY]) {
				return true;
			}
		}
		return isOkay;
	}
}