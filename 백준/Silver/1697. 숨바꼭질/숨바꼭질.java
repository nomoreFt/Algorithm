import java.io.*;
import java.sql.Array;
import java.util.*;


class Main {
    static final int MAX = 100001;
    static int[] d = new int[MAX];


    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        d[start] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();

            if (now - 1 >= 0) {
                if (d[now - 1] == -1) {
                    d[now -1] = d[now] + 1;
                    q.offer(now - 1);
                }
            }if (now +1 < MAX) {
                if (d[now + 1] == -1) {
                    d[now +1] = d[now] + 1;
                    q.offer(now + 1);
                }
            }if (now * 2 < MAX) {
                if (d[now*2] == -1) {
                    d[now*2] = d[now] + 1;
                    q.offer(now*2);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        d = new int[MAX];
        Arrays.fill(d,-1);

        bfs(n);

        System.out.println(d[k]);
    }
}