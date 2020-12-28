package BAEKJOON.BruteForce.Permutation;

import java.io.*;

public class _6603_nCr {
	static int N;
	static int[] arr;
	static int[] output;
	static boolean visited[];
	static int lottoNum = 6;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				String[] strs = br.readLine().split(" ");
				N = Integer.parseInt(strs[0]);
				if(N==0) break;
				arr = new int[N];
				visited = new boolean[N];
				output = new int[lottoNum];
				for(int i = 0; i < N; i++) {
					arr[i] = Integer.parseInt(strs[i+1]);
				}
				dfs(0,0);
				sb.append("\n");
			}
			System.out.print(sb.toString());
	}
	static void dfs(int index, int depth) {
		if(depth==lottoNum) {
			print(output);
			return;
		}
		for(int i = index; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			output[depth] = arr[i];
			dfs(i+1,depth+1);
			visited[i] = false;
		}
	}
	static void print(int[] output) {
		for(int i = 0; i < output.length; i++) {
				if(i == output.length-1) sb.append(output[i]+"\n");
				else sb.append(output[i] + " ");
		}
	}
}
