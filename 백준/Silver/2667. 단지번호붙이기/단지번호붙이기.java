import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int cnt = 0;
    static List<Integer> arr = new ArrayList<>();
    static int nX[] = {1,-1,0,0};
    static int nY[] = {0, 0, 1, -1};
    static int[][] graph;

    static boolean[][] visited;
    static class Node{
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(strs[j]);
            }
        }


        int danzi = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(graph[i][j] == 0) continue;
                cnt = 0;
                danzi++;
                bfs(i, j);
                arr.add(cnt);
            }
        }

        System.out.println(danzi);
        arr.sort(Comparator.naturalOrder());
        for (int a : arr) {
            System.out.println(a);
        }
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        Node n = new Node(x, y);
        q.offer(n);
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            graph[node.x][node.y] = 0;
            cnt++;
            
            for (int i = 0; i < 4; i++) {
                int nx = node.x + nX[i];
                int ny = node.y + nY[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && graph[nx][ny] != 0 && !visited[nx][ny]) {
                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
