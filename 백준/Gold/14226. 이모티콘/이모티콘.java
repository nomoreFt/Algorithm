import java.io.*;
import java.sql.Array;
import java.util.*;


class Main {
    static class Edge{
        int screen,clipboard;
        public Edge(int s, int c) {
            this.screen = s;
            this.clipboard = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(d[i],-1);
        }

        Queue<Edge> q = new LinkedList<>();
        q.offer(new Edge(1, 0));
        d[1][0] = 0;
        while (!q.isEmpty()) {
            Edge now = q.poll();
            int nowScreen = now.screen;
            int nowClip = now.clipboard;
            if (d[nowScreen][nowScreen] == -1) {
                d[nowScreen][nowScreen] = d[nowScreen][nowClip]+1;
                q.offer(new Edge(nowScreen, nowScreen));
            }
            if (nowScreen + nowClip <= n && d[nowScreen + nowClip][nowClip] == -1) {
                d[nowScreen + nowClip][nowClip] = d[nowScreen][nowClip] + 1;
                q.offer(new Edge(nowScreen + nowClip, nowClip));
            }
            if (nowScreen - 1 >= 0 && d[nowScreen - 1][nowClip] == -1) {
                d[nowScreen - 1][nowClip] = d[nowScreen][nowClip] + 1;
                q.offer(new Edge(nowScreen - 1, nowClip));
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            if (d[n][i] != -1) {
                ans = Math.min(ans, d[n][i]);
            }
        }
        System.out.println(ans);
    }
}