
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int N,M;
    static int[] dist;
    static int[] next;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        dist = new int[101];
        next = new int[101];

        for (int i = 1; i <= 100; i++) {
            dist[i] = -1;
            next[i] = i;
        }

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            next[a] = b;
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            next[a] = b;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 1; i <= 6; i++) {
                if(now + i > 100) continue;
                int nextPoint = next[now + i];

                if (dist[nextPoint] == -1) {
                    dist[nextPoint] = dist[now]+1;
                    q.offer(nextPoint);
                }
            }
        }

        System.out.println(dist[100]);

    }

}