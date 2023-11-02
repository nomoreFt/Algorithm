import java.io.*;
import java.util.*;

class Main {
    static int N,M;
    static int[][] graph;
    static boolean[][] visited;
    static int MAX = Integer.MIN_VALUE;

    static class Node{
        int x,y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    //남,북,동,서
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(new Node(i,j), 1, graph[i][j]);
                visited[i][j] = false;

                calculateT(new Node(i,j));
            }
        }

        System.out.println(MAX);


    }
    //남북동서
    static void calculateT(Node now) {
        //ㅓ
        if(now.y - 1 >= 0 && now.x + 1 < N && now.x - 1 >= 0) {
            MAX = Math.max(MAX,
                    graph[now.x][now.y] + graph[now.x][now.y - 1] + graph[now.x + 1][now.y] + graph[now.x - 1][now.y]);
        }
        //ㅏ
        if(now.y + 1 < M && now.x + 1 < N && now.x - 1 >= 0)
            MAX = Math.max(MAX,
                    graph[now.x][now.y] + graph[now.x][now.y + 1] + graph[now.x + 1][now.y] + graph[now.x - 1][now.y]);
        //ㅗ
        if(now.x - 1 >= 0 && now.y - 1 >= 0 && now.y + 1 < M)
            MAX= Math.max(MAX,
                    graph[now.x][now.y] + graph[now.x - 1][now.y] + graph[now.x][now.y - 1] + graph[now.x][now.y + 1]);

        //ㅜ

        if(now.x + 1 < N && now.y - 1 >= 0 && now.y + 1 < M)
        MAX = Math.max(MAX,
                graph[now.x][now.y] + graph[now.x + 1][now.y] + graph[now.x][now.y - 1] + graph[now.x][now.y + 1]);

    }

    static void dfs(Node now, int idx, int sum){
        if(idx == 4){
            MAX = Math.max(MAX, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nX = now.x + dx[i];
            int nY = now.y + dy[i];

            if(nX < 0 || nX >= N || nY < 0 || nY >= M) continue;
            if(visited[nX][nY]) continue;

            visited[nX][nY] = true;
            dfs(new Node(nX, nY), idx + 1, sum + graph[nX][nY]);
            visited[nX][nY] = false;
        }
    }






}