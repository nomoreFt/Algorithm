import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int n;
    static char[][] graph;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new char[n][n];

        for (int i = 0; i < n; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        int ans1 = getGroupCnt(false);
        int ans2 = getGroupCnt(true);

        System.out.println(ans1 + " " + ans2);
    }
    private static int getGroupCnt(boolean blind) {
        int[][] dist = new int[n][n];
        int group = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(dist[i][j] == 0){
                    bfs(blind, i, j, group, dist);
                    group++;
                }
            }
        }
        return getMaxGroupNum(dist);
    }
    private static int getMaxGroupNum(int[][] dist) {
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dist[i][j]);
            }
        }
        return max;
    }
    private static void bfs(boolean blind, int startX, int startY, int group, int[][] dist) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startX, startY));
        dist[startX][startY] = group;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nX = now.x + dx[i];
                int nY = now.y + dy[i];

                if (0 <= nX && nX < n && 0 <= nY && nY < n && dist[nX][nY] == 0) {
                    if (blind) {
                        if (graph[now.x][now.y] == graph[nX][nY]) {
                            q.offer(new Node(nX, nY));
                            dist[nX][nY] = group;
                            continue;
                        }
                        if (graph[now.x][now.y] == 'R' || graph[now.x][now.y] == 'G') {
                            if(graph[nX][nY] == 'R' || graph[nX][nY] == 'G'){
                                q.offer(new Node(nX, nY));
                                dist[nX][nY] = group;
                            }
                        }
                        //장님이 아닌 경우
                    }else{
                        if (graph[now.x][now.y] == graph[nX][nY]) {
                            q.offer(new Node(nX, nY));
                            dist[nX][nY] = group;
                            continue;
                        }
                    }

                }
            }

        }

    }
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
