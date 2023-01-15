import java.io.*;
import java.sql.Array;
import java.util.*;


class Main {
    static int n,k;
    static int MAX = 200000;
    static int[] d;
    static int[] from;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        k = Integer.parseInt(strs[1]);
        d = new int[MAX];
        from = new int[MAX];

        Arrays.fill(d,-1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        d[n] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now - 1 >= 0) {
                if (d[now - 1] == -1) {
                    d[now-1] = d[now] + 1;
                    q.offer(now - 1);
                    from[now-1] = now;
                }
            }
            if (now + 1 < MAX) {
                if (d[now + 1] == -1) {
                    d[now + 1] = d[now] + 1;
                    q.offer(now + 1);
                    from[now+1] = now;
                }
            }
            if (now * 2 < MAX) {
                if (d[now * 2] == -1) {
                    d[now * 2] = d[now] + 1;
                    q.offer(now *2);
                    from[now*2] = now;
                }
            }
        }

        System.out.println(d[k]);
        print(n, k);
    }
    public static void print(int a, int b) {
        if (a != b) {
            print(a, from[b]);
        }
        System.out.print(b+" ");
    }
}