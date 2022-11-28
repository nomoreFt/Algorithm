import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static int N, K;
    static int min = Integer.MAX_VALUE;
    static int count = 0;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);

        if (N >= K) {
            System.out.println(N - K);
            System.out.println(1);
            return;
        }

        bfs();
        System.out.println(min);
        System.out.println(count);

    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (min < visited[now]) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next = 0;
                if (i == 0) {
                    next = now - 1;
                } else if (i == 1) {
                    next = now + 1;
                } else {
                    next = now * 2;
                }

                if(next == K) {
                    min = visited[now];
                    count++;
                }
                if (next < 0 || next > 100000) continue;
                if (visited[next] == 0 || visited[next] == visited[now] + 1) {
                    visited[next] = visited[now] + 1;
                    q.add(next);
                }

            }
        }

    }

}




