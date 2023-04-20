import java.io.*;
import java.util.*;


public class Main {
    static int n,m;
    static int[][] graph;
    static class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] unionGraph;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[1]);
        m = Integer.parseInt(strs[0]);

        graph = new int[n][m];
        unionGraph = new int[n][m];

        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }


        int groupNum = 0;
        int maxRoomCnt = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (unionGraph[i][j] == 0) {

                    groupNum++;
                    int cnt = bfs(new Node(i,j),groupNum);
                    maxRoomCnt = Math.max(maxRoomCnt, cnt);
                }
                }
            }


        System.out.println(groupNum);
        System.out.println(maxRoomCnt);

        int[] d = new int[groupNum+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[unionGraph[i][j]]++;
            }
        }


        int ans = -1;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                int nowGroup = unionGraph[x][y];

                for (int k = 0; k < 4; k++) {
                    int nX = x + dx[k];
                    int nY = y + dy[k];

                    if(nX < 0 || nX >= n || nY < 0 || nY >= m) continue;
                    if(unionGraph[nX][nY] == nowGroup) continue;
                    //벽 부수면 합쳐짐
                    if ((graph[x][y] & (1 << k)) > 0) {
                        int now = d[nowGroup];
                        now += d[unionGraph[nX][nY]];
                        ans = Math.max(ans, now);
                    }

                }

            }
        }
        System.out.println(ans);

    }

    private static int bfs(Node start, int groupVal) {
        Queue<Node> q = new LinkedList<>();
        unionGraph[start.x][start.y] = groupVal;
        q.offer(start);
        int cnt = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
                cnt++;

            for (int i = 0; i < 4; i++) {
                int nX = now.x + dx[i];
                int nY = now.y + dy[i];
                if(nX < 0 || nX >= n || nY < 0 || nY >= m) continue;
                if(unionGraph[nX][nY] != 0) continue;
                if((graph[now.x][now.y] & (1 << i)) > 0) continue;
                q.add(new Node(nX, nY));
                unionGraph[nX][nY] = groupVal;
            }
        }
        return cnt;
    }
}


