import java.io.*;
import java.util.*;


public class Main {
    static int n,m;
    static int[][] graph;



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);

        graph = new int[n][m];
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            strs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(strs[j]);
                dist[i][j] = Integer.parseInt(strs[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int maxDist = -1;
                if(i-1 >= 0){
                    maxDist = Math.max(maxDist, dist[i - 1][j]);
                }
                if (j - 1 >= 0) {
                    maxDist = Math.max(maxDist, dist[i][j-1]);
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    maxDist = Math.max(maxDist, dist[i - 1][j - 1]);
                }

                if (maxDist != -1) {
                    dist[i][j] = maxDist + graph[i][j];
                }

            }
        }


        System.out.println(dist[n-1][m-1]);





    }
}


