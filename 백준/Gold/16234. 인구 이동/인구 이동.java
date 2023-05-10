import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N;
    static int L,R;
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        int result = 0;
        while (true) {
            if (go()) {
                result++;
            } else {
                break;
            }
        }

        System.out.println(result);
    }

    public static boolean go() {
        boolean ok = true;

        int[][] unions = new int[N][N];
        int unionNum = 0;




        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (unions[i][j] == 0) {
                    unionNum++;
                    findUnion(unions, unionNum, new Node(i,j));
                }
            }
        }

        if(unionNum == N * N) return false;


        return ok;
    }

    public static void findUnion(int[][] unions,int unionNum, Node start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        unions[start.x][start.y] = unionNum;

        Queue<Node> qUnion = new LinkedList<>();
        qUnion.offer(start);
        int unionCnt = 1;
        int sum = graph[start.x][start.y];

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = now.x + dx[i];
                int nY = now.y + dy[i];

                if(nX < 0 || nX >= N || nY < 0 || nY >= N) continue;
                if(unions[nX][nY] != 0) continue;

                int diff = Math.abs(graph[now.x][now.y] - graph[nX][nY]);
                if(diff >= L && diff <= R){
                    q.offer(new Node(nX, nY));
                    unions[nX][nY] = unionNum;
                    qUnion.offer(new Node(nX, nY));
                    unionCnt++;
                    sum += graph[nX][nY];
                }
            }
        }

        if(unionCnt == 1) return;
        int val = sum / unionCnt;
        while (!qUnion.isEmpty()) {
            Node now = qUnion.poll();
            graph[now.x][now.y] = val;
        }
    }
}