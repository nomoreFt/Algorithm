import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] graph;
    static int n,k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        graph = new int[100001];

        if (n == k) {
            System.out.println(0);
        }else{
            bfs();
        }

    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        graph[n] = 1;
        q.offer(n);
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = cur + 1;
                } else if (i == 1) {
                    next = cur - 1;
                }else{
                    next = cur * 2;
                }
                if (next == k) {
                    System.out.println(graph[cur]);
                    return;
                }

                if(next <0 || next >= graph.length || graph[next] != 0) continue;

                q.offer(next);
                graph[next] = graph[cur] + 1;
            }
        }
    }
}