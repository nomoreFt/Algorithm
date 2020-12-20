package BAEKJOON.BruteForce.Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 ////
public class _10971 {
 
    static int n ;
    static int[][] arr;
    static long min = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];
 
         for (int i = 0; i <n ; i++) {
        	 String[] str = br.readLine().split(" ");
             for (int j = 0; j <n ; j++) {
                 arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        for (int i = 0; i <n ; i++) {
            dfs(i,i,0,0);
        }
        System.out.println(min);
    }
    public static void dfs(int start, int i, int depth, int sum){
        if(depth == n && start == i){
            min = Math.min(min, sum);
            return;
        } 
        for (int j = 0; j <n ; j++) {
            if(arr[i][j]==0 || visited[i]){
                continue;
            }
                visited[i]=true;
                sum += arr[i][j];
                dfs(start, j, depth +1, sum);
                visited[i] = false;
                sum -= arr[i][j];
        }
    }
 
}