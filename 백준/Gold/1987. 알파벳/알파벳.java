import java.io.*;
import java.util.*;

public class Main {
	static int r,c;
	static int[][] map;
	static boolean[] checked;
	static int max=0;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		checked = new boolean[26];
		for(int i=0; i<r; i++) {
			String[] line = br.readLine().split("");
			for(int j=0; j<line.length; j++) {
				String alpha = line[j];
				map[i][j] = alpha.charAt(0)-'A';
			}
		}
		dfs(0,0,0);
		System.out.println(max);
	}
	
	static void dfs(int x, int y, int cnt) {
		if(checked[map[x][y]]) {
			max = Math.max(max, cnt);
			return;
		}
		else {
			checked[map[x][y]] = true;
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
			
				if(nx<0 || ny <0 || nx >r-1 || ny > c-1) continue;
				dfs(nx, ny, cnt+1);
			}
			checked[map[x][y]] = false;
		}
	}
}