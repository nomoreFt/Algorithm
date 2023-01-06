import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n , m, start;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        start = Integer.parseInt(strs[2]);
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            strs = br.readLine().split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }
        visited = new boolean[n + 1];
        dfs(start);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(start);
        System.out.println();

    }

    public static void dfs(int now) {
        if(visited[now]) return;
        visited[now] = true;
        System.out.print(now + " ");
        for (int y : graph[now]) {
            if (visited[y] == false) {
                dfs(y);
            }
        }
    }

    public static void bfs(int now) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(now);
        visited[now] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");
            for (int y : graph[x]) {
                if(visited[y]) continue;
                visited[y] = true;
                q.offer(y);
            }
        }
    }
}

