import java.io.*;
import java.sql.Array;
import java.util.*;


class Main {
    static int n,m,r;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        r = Integer.parseInt(strs[2]);

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            strs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(strs[j]);
            }
        }


        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        int groupn = Math.min(n, m) / 2;

        for (int k = 0; k < groupn; k++) {
            ArrayList<Integer> group = new ArrayList<>();

            for (int j = k; j < m - 1 -k; j++) {
                group.add(graph[k][j]);
            }

            for (int i = k; i < n - 1 - k; i++) {
                group.add(graph[i][m - 1 - k]);
            }

            for (int j = m - 1 - k; j > k; j--) {
                group.add(graph[n - 1 - k][j]);
            }

            for (int i = n - 1 - k; i > k; i--) {
                group.add(graph[i][k]);
            }
            groups.add(group);
        }

        for(int k = 0; k < groupn; k++){
            ArrayList<Integer> group = groups.get(k);
            int len = group.size();
            int index = r % len;
            for (int j = k; j < m - 1 -k; j++ ) {
                graph[k][j] = group.get(index);
                index = (index + 1) % len;

            }

            for (int i = k; i < n - 1 - k; i++) {
                graph[i][m - 1 - k] = group.get(index);
                index = (index + 1) % len;
            }

            for (int j = m - 1 - k; j > k; j--) {
                graph[n - 1 - k][j] = group.get(index);
                index = (index + 1) % len;
            }

            for (int i = n - 1 - k; i > k; i--) {
                graph[i][ k] = group.get(index);
                index = (index + 1) % len;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
