import java.io.*;
import java.util.*;


public class Main {
    static int n, m;
    static char[][] graph;
    static class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] strs = br.readLine().split(" ");
            n = Integer.parseInt(strs[1]);
            m = Integer.parseInt(strs[0]);

            if(n == 0 && m == 0) break;

            graph = new char[n][m];
            ArrayList<Node> dirtyZone = new ArrayList<Node>();

            for (int i = 0; i < n; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    graph[i][j] = chars[j];
                    if (graph[i][j] == 'o') {
                        dirtyZone.add(0,new Node(i, j));
                    }
                    if (graph[i][j] == '*') {
                        dirtyZone.add(new Node(i, j));
                    }
                }
            }

            int size = dirtyZone.size();
            int[][] d = new int[size][size];
            boolean ok = true;
            for (int start = 0; start < size; start++) {
                Node startNode = dirtyZone.get(start);
                int[][] dist = bfs(startNode);
                for (int target = 0; target < size; target++) {
                    Node targetNode = dirtyZone.get(target);
                    d[start][target] = dist[targetNode.x][targetNode.y];
                    if(d[start][target] == -1) ok = false;
                }
            }
            if (!ok) {
                System.out.println(-1);
                continue;
            }

            int[] p = new int[size-1];
            for (int i = 0; i < size - 1; i++) {
                p[i] = i+1;
            }

            int ans = -1;

            do {
                int now = d[0][p[0]];
                for (int i = 0; i < size - 2; i++) {
                    now += d[p[i]][p[i + 1]];
                }

                if (ans == -1) {
                    ans = now;
                }else{
                ans = Math.min(ans, now);
                }

            } while (next_permutation(p));

            System.out.println(ans);
            }
        }


    static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }
        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }
        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;
        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }


    private static int[][] bfs(Node startNode) {
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(startNode);
        dist[startNode.x][startNode.y] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = dx[i] + now.x;
                int nY = dy[i] + now.y;

                if(nX < 0 || nX >= n || nY < 0 || nY >= m) continue;
                if (dist[nX][nY] == -1 && graph[nX][nY] != 'x') {
                    q.offer(new Node(nX, nY));
                    dist[nX][nY] = dist[now.x][now.y] + 1;
                }
            }
        }
        return dist;
    }

}

