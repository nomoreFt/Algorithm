import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int color[];
    static ArrayList<Integer>[] graph;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            color = new int[n + 1];
            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            boolean ok = true;
            for (int i = 1; i <= n; i++) {
                if (color[i] == 0) {
                    if (dfs(i, 1) == false) {
                        ok = false;
                    }
                }
            }
            if (ok) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    public static boolean dfs(int now, int c) {
        //첫 시작에 1,2인지 선택
        color[now] = c;
        //now 지금과 연결된 간선에서
        for (int y : graph[now]) {
            //만난 적 없는 간선일 경우
            if (color[y] == 0) {
                //재귀적으로 다른 팀인지 아닌지 체크해서 아니면 false
                if (dfs(y, 3 - c) == false) {
                    return false;
                }
                //만난 적 있는 간선일 경우 다른 팀이면 false
            } else if (color[y] == color[now]) {
                return false;
            }
        }
        return true;
    }
}