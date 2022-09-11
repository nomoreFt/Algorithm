import java.io.*;
import java.util.*;

public class Main {
   static int[][] graph;
   static ArrayList<Integer> arr = new ArrayList<>();
   static boolean[] visited;
   static int n;
   static int min = Integer.MAX_VALUE;
   static void diff() {
    int team_start = 0;
    int team_link = 0;
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (visited[i] == true && visited[j] == true) {
                team_start += graph[i][j];
                team_start += graph[j][i];
            }
            else if (visited[i] == false && visited[j] == false) {
                team_link += graph[i][j];
                team_link += graph[j][i];
            }
        }
    }
    int val = Math.abs(team_start - team_link);
    if (val == 0) {
        System.out.println(val);
        System.exit(0);
    }
    min = Math.min(val, min);
}
static void combi(int idx, int count) {
    if(count == n / 2) {
        diff();
        return;
    }
    for(int i = idx; i < n; i++) {
        if(!visited[i]) {
            visited[i] = true;	// 방문으로 변경
            combi(i + 1, count + 1);	// 재귀 호출
            visited[i] = false;	// 재귀가 끝나면 비방문으로 변경
        }
    }
}
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] strs;
        graph = new int[n][n];
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        combi(0,0);
        System.out.println(min);

  
    
        
     
    }
}
