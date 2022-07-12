import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int x;
    int y;
    int cnt;

    public Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Node other) {
        return cnt - other.cnt;
    }
}
class Main {
    static int n,m;
    static int[][] graph;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // 가로
        n = Integer.parseInt(st.nextToken()); // 세로
       /* n = Integer.parseInt(strs[1]);
        m = Integer.parseInt(strs[0]);
*/
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        int result = bfs(0, 0);
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();

    }

    static int bfs(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, y, 0));
        boolean[][] visited = new boolean[n][m];
        visited[x][y] = true;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.x == n - 1 && node.y == m - 1) {
                return node.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nX = dx[i] + node.x;
                int nY = dy[i] + node.y;

                if(nX < 0 || nX >= n || nY < 0 || nY >= m) continue;

                if (!visited[nX][nY] && graph[nX][nY] == 0) {
                 visited[nX][nY] = true;
                    pq.offer(new Node(nX, nY, node.cnt));
                }

                if (!visited[nX][nY] && graph[nX][nY] == 1) {
                    visited[nX][nY] = true;
                    pq.offer(new Node(nX, nY, node.cnt + 1));
                }
            }
        }
        return 0;
    }
}
