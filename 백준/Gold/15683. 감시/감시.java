import java.io.*;
import java.util.*;


public class Main {
    static class Node{
        int x;
        int y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N,M;
    static ArrayList<Node> cctvs = new ArrayList<>();
    static int MIN = Integer.MAX_VALUE;
    static boolean[] visited;

    static int dx[] = {-1, 0, 1, 0};//북동남서
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        int[][] graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = sc.nextInt();
                if(graph[i][j] != 0 && graph[i][j] != 6){
                    cctvs.add(new Node(i, j));
                }
            }
        }

        if (cctvs.size() == 0) {
            // cctv가 없을 때
            // 사각지대를 구한다.
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    if(graph[i][j] == 0){
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
            return;
        }

        visited = new boolean[cctvs.size()];

        go(graph, 0);
        System.out.println(MIN);

    }

    public static void go(int[][] graph, int idx) {

        if(idx == cctvs.size()){
            // 모든 cctv를 다 봤을 때
            // 사각지대를 구한다.
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    if(graph[i][j] == 0){
                        cnt++;
                    }
                }
            }
            MIN = Math.min(MIN, cnt);
            return;
        }

        int[][] copyGraph = new int[N][M];
        rollback(graph, copyGraph);


        Node cctvNow = cctvs.get(idx);

        int kindOfCctv = graph[cctvNow.x][cctvNow.y];

        if (kindOfCctv == 1) {
            for (int i = 0; i < 4; i++) {
                go1cctv(i,cctvNow,copyGraph);
                go(copyGraph, idx + 1);
                rollback(graph, copyGraph);
            }


        }else if(kindOfCctv == 2){
            for (int i = 0; i < 2; i++) {
                go2cctv(i,cctvNow,copyGraph);
                go(copyGraph, idx + 1);
                rollback(graph, copyGraph);
            }

        }else if(kindOfCctv == 3){
            for (int i = 0; i < 4; i++) {
                go3cctv(i,cctvNow,copyGraph);
                go(copyGraph, idx + 1);
                rollback(graph, copyGraph);
            }

        }else if(kindOfCctv == 4){
            for (int i = 0; i < 4; i++) {
                go4cctv(i,cctvNow,copyGraph);
                go(copyGraph, idx + 1);
                rollback(graph, copyGraph);
            }

        }else if(kindOfCctv == 5){
            go5cctv(cctvNow, copyGraph);
            go(copyGraph, idx + 1);
            rollback(graph, copyGraph);
        }
    }

    private static void rollback(int[][] graph, int[][] copyGraph) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyGraph[i][j] = graph[i][j];
            }
        }
    }

    private static void go5cctv(Node cctvNow, int[][] copyGraph) {
        for (int i = 0; i < 4; i++) {
            int nx = cctvNow.x + dx[i];
            int ny = cctvNow.y + dy[i];

            while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if(copyGraph[nx][ny] == 6){
                    break;
                }
                if (copyGraph[nx][ny] == 0) {
                    copyGraph[nx][ny] = -1;
                }
                nx += dx[i];
                ny += dy[i];
            }
        }
    }

    private static void go4cctv(int dir, Node cctvNow, int[][] copyGraph) {
        //북
        int nx = cctvNow.x + dx[dir];
        int ny = cctvNow.y + dy[dir];

        while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
            if(copyGraph[nx][ny] == 6){
                break;
            }
            if (copyGraph[nx][ny] == 0) {
                copyGraph[nx][ny] = -1;
            }
            nx += dx[dir];
            ny += dy[dir];
        }


        //동
        nx = cctvNow.x + dx[(dir + 1)%4];
        ny = cctvNow.y + dy[(dir + 1)%4];

        while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
            if(copyGraph[nx][ny] == 6){
                break;
            }
            if (copyGraph[nx][ny] == 0) {
                copyGraph[nx][ny] = -1;
            }
            nx += dx[(dir + 1)%4];
            ny += dy[(dir + 1)%4];
        }

        //서
        nx = cctvNow.x + dx[(dir - 1 + 4)%4];
        ny = cctvNow.y + dy[(dir - 1 + 4)%4];

        while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
            if(copyGraph[nx][ny] == 6){
                break;
            }
            if (copyGraph[nx][ny] == 0) {
                copyGraph[nx][ny] = -1;
            }
            nx += dx[(dir - 1 + 4)%4];
            ny += dy[(dir - 1 + 4)%4];
        }
    }

    private static void go3cctv(int dir, Node cctvNow, int[][] copyGraph) {

        int nx = cctvNow.x + dx[dir];
        int ny = cctvNow.y + dy[dir];

        while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
            if(copyGraph[nx][ny] == 6){
                break;
            }
            if (copyGraph[nx][ny] == 0) {
                copyGraph[nx][ny] = -1;
            }
            nx += dx[dir];
            ny += dy[dir];
        }

        nx = cctvNow.x + dx[(dir+1)%4];
        ny = cctvNow.y + dy[(dir+1)%4];

        while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
            if(copyGraph[nx][ny] == 6){
                break;
            }
            if (copyGraph[nx][ny] == 0) {
                copyGraph[nx][ny] = -1;
            }
            nx += dx[(dir+1)%4];
            ny += dy[(dir+1)%4];
        }
    }

    private static void go2cctv(int dir, Node cctvNow, int[][] copyGraph) {

        int nx = cctvNow.x + dx[dir];
        int ny = cctvNow.y + dy[dir];

        while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
            if(copyGraph[nx][ny] == 6){
                break;
            }
            if (copyGraph[nx][ny] == 0) {
                copyGraph[nx][ny] = -1;
            }
            nx += dx[dir];
            ny += dy[dir];
        }
        //남
        nx = cctvNow.x + dx[dir+2];
        ny = cctvNow.y + dy[dir+2];

        while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
            if(copyGraph[nx][ny] == 6){
                break;
            }
            if (copyGraph[nx][ny] == 0) {
                copyGraph[nx][ny] = -1;
            }
            nx += dx[dir+2];
            ny += dy[dir+2];
        }

    }

    private static void go1cctv(int dir, Node cctvNow, int[][] copyGraph) {
        int nx = cctvNow.x + dx[dir];
        int ny = cctvNow.y + dy[dir];

        while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
            if(copyGraph[nx][ny] == 6){
                break;
            }
            if (copyGraph[nx][ny] == 0) {
                copyGraph[nx][ny] = -1;
            }
            nx += dx[dir];
            ny += dy[dir];
        }
    }
}

