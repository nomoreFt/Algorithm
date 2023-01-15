import java.io.*;
import java.sql.Array;
import java.util.*;


class Main {
    static int n,k;
    static int MAX = 200000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        k = Integer.parseInt(strs[1]);

        int[] dist = new int[MAX];

        Arrays.fill(dist, -1);

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(n);
        dist[n] = 0;
        while (!deque.isEmpty()) {
            int now = deque.poll();

            if (now * 2 < MAX && dist[now * 2] == -1) {
                dist[now * 2] = dist[now];
                deque.addFirst(now * 2);
            }
            if (now-1 >= 0 && dist[now - 1] == -1) {
                dist[now - 1] = dist[now] + 1;
                deque.addLast(now -1);
            }

            if (now+1 < MAX && dist[now + 1] == -1) {
                dist[now + 1] = dist[now] + 1;
                deque.addLast((now + 1));
            }
        }

        System.out.println(dist[k]);



    }
}