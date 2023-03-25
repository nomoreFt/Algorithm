import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] arr = new ArrayList[n];
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        int[] order = new int[n];

        for(int i= 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            order[i] = sc.nextInt() - 1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        int qSize = 1;
        for (int i = 0; i < n; i++) {
            if (q.isEmpty()) {
                System.out.println(0);
                System.exit(0);
            }
            int now = q.poll();
            if (now != order[i]) {
                System.out.println(0);
                System.exit(0);
            }
            int cnt = 0;
            for (int y : arr[now]) {
                if (!visited[y]) {
                    cnt++;
                    parent[y] = now;
                }
            }

            for (int j = 0; j < cnt; j++) {
                if (qSize + j >= n || parent[order[qSize + j]] != now) {
                    System.out.println(0);
                    System.exit(0);
                }
                q.add(order[qSize + j]);
                visited[order[qSize + j]] = true;
            }
            qSize += cnt;
        }
        System.out.println(1);
    }
}