import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static char[][] graph;
    static boolean[][] visited;
    static ArrayList<String> strs = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        graph = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            graph[i] = temp.clone();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == '*') {
                    checkCross(i, j,bw);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(graph[i][j] == '*' && visited[i][j] == false){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(strs.size());
        for (int i = 0; i < strs.size(); i++) {
            System.out.println(strs.get(i));
        }
    }

    private static void checkCross(int x, int y, BufferedWriter bw) throws IOException {
        int size = 0;
        for (int i = 1; ; i++) {
            if(x-i < 0 || x+i >= N || y-i < 0 || y+i >= M) break;
            if(graph[x-i][y] != '*' || graph[x+i][y] != '*' || graph[x][y-i] != '*' || graph[x][y+i] != '*') break;
            size = i;
        }

        if (size > 0) {
            strs.add((x+1) + " " + (y+1) + " " + size);
            cnt++;
            visited[x][y] = true;
            for (int i = 1; i <= size; i++) {
                visited[x-i][y] = true;
                visited[x+i][y] = true;
                visited[x][y-i] = true;
                visited[x][y+i] = true;
            }
        }
    }
}
