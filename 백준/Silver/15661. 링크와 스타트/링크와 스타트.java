import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] graph;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int t;
    
    static void diff(){
        int start = 0;
        int link = 0;

        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j< n; j++){
                if(visited[i] && visited[j]){
                    start += (graph[i][j] + graph[j][i]);
                }else if(!visited[i] && !visited[j]){
                    link += (graph[i][j] + graph[j][i]);
                }
            }
        }
        
        int val = Math.abs(start-link);
        if(val == 0){
            System.out.println(0);
            System.exit(0);
        }
        min = Math.min(min,val);
    }
    static void dfs(int idx, int depth){
        if(depth == t){
            diff();
            return;
        }
        for(int i = idx; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i+1,depth+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(t = 1; t < n; t++){
            dfs(0,0);
        }
        System.out.println(min);
    }
}
