import java.io.*;

public class Main{
	static int N,S,cnt = 0;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = bf.readLine().split(" ");
		N =	Integer.parseInt(strs[0]);
		S =	Integer.parseInt(strs[1]);
		arr = new int[N];
		visited = new boolean[N];
		strs = bf.readLine().split(" ");
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		
		for(int i = 0 ; i < N; i++) {
			DFS(i+1,0,0,0);
		}
		System.out.println(cnt);
	}
	public static void DFS(int length,int idx, int depth, int sum) {
		if(depth == length) {
			if(sum == S) cnt++;
			return;
		}
		for(int i = idx ; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			DFS(length,i+1,depth+1,sum+arr[i]);
			visited[i] = false;
		}
	}
}