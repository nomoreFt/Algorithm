import java.io.*;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;


class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] check;
    static int[] dist;
    public static int go(int x, int p) {//p = prev, x = now
        if (check[x] == 1) {
            return x;
        }
        check[x] = 1;
        for (int y : graph[x]) {
            if(y == p) continue;
            int res = go(y, x);
            if(res == -2) return -2;
            if (res >= 0) {
                check[x] = 2;
                if(x == res) return -2;
                else return res;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        dist = new int[N];
        check = new int[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split(" ");
            int a = Integer.parseInt(strs[0])-1;
            int b = Integer.parseInt(strs[1])-1;
            graph[a].add(b);
            graph[b].add(a);
        }
        go(0, -1);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (check[i] == 2) {
                dist[i] = 0;
                q.add(i);
            }else{
                dist[i] = -1;
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int y : graph[now]) {
                if (dist[y] == -1) {
                    q.add(y);
                    dist[y] = dist[now]+1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();



    }
}
