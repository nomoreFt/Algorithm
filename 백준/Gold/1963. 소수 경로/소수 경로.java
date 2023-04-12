import java.io.*;
import java.util.*;


public class Main {
    static int T;
    static boolean[] isPrime = new boolean[10001];
    static int[] dist;
    public static void main(String[] args) {
        for (int i = 2; i < 10000; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j < 10000;) {
                    isPrime[j] = true;
                    j += i;
                }
            }
        }

        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();


        while (T-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            dist = new int[10000];
            Arrays.fill(dist,-1);
            Queue<Integer> q = new LinkedList<>();
            q.offer(a);
            dist[a] = 0;
            while (!q.isEmpty()) {
                int now = q.poll();

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j <= 9; j++) {
                        if(i == 0 && j == 0) continue;
                        int next = changeNum(now, i, j);

                        if (!isPrime[next] && dist[next] == -1) {
                            q.offer(next);
                            dist[next] = dist[now] + 1;
                        }
                    }
                }
            }
            if(dist[b] == -1){
                System.out.println("Impossible");
            }else{
                System.out.println(dist[b]);
            }
        }
    }

    private static int changeNum(int now, int idx, int digit) {
        String str = Integer.toString(now);

        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(idx, (char)(digit+'0'));
        return Integer.parseInt(sb.toString());
    }
}
