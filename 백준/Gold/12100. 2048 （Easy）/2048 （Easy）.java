import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Main {
    static int N;
    static int[][] graph;
    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(0);
        System.out.println(result);
    }
    static void dfs(int depth) {
        if (depth == 5) {
            findMax();
            return;
        }
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            temp[i] = graph[i].clone();
        }
        for (int i = 0; i < 4; i++) {
            move(i);
            dfs(depth + 1);
            for (int j = 0; j < N; j++) {
                graph[j] = temp[j].clone();
            }
        }
    }

    private static void findMax() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, graph[i][j]);
            }
        }
    }

    static void move(int dir) {
        // 0: 왼쪽, 1: 오른쪽, 2: 위쪽, 3: 아래쪽
        LinkedList<Integer> q = new LinkedList<>();
        if (dir == 0) {
            for (int i = 0; i < N; i++) {// 행 반복

                //0으로 초기화, Q에 다 집어넣기 (한 숫자 당, 한 번만 동작하면 되므로)
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] != 0) {
                        q.add(graph[i][j]);
                        graph[i][j] = 0;
                    }
                }

                //Q에서 하나씩 꺼내서, 0이면 넣고, 0이 아니면, 이전 값과 비교해서 같으면 더하고, 다르면 넣기
                int idx = 0; //graph에서 숫자 넣을 자리 target
                while (!q.isEmpty()) {
                    int now = q.poll();//q에서 계속 꺼내 비교, q가 비면 종료
                    if (graph[i][idx] == 0) {
                        graph[i][idx] = now;
                    } else if (graph[i][idx] == now) {
                        graph[i][idx] *= 2;
                        idx++;
                    }else{
                        idx++;
                        graph[i][idx] = now;
                    }
                }
            }
        } else if (dir == 1) { //오른쪽
            for (int i = 0; i < N; i++) {
                for (int j = N-1; j >=0; j--) {
                    if (graph[i][j] != 0) {
                        q.add(graph[i][j]);
                        graph[i][j] = 0;
                    }
                }
                int idx = N - 1;
                while (!q.isEmpty()) {
                    int cur = q.poll();

                    if (graph[i][idx] == 0) {
                        graph[i][idx] = cur;
                    } else if (graph[i][idx] == cur) {
                        graph[i][idx] *= 2;
                        idx--;
                    }else{
                        idx--;
                        graph[i][idx] = cur;
                    }
                }
            }
        } else if (dir == 2) { //위쪽
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[j][i] != 0) {
                        q.add(graph[j][i]);
                        graph[j][i] = 0;
                    }
                }
                int idx = 0;
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    if (graph[idx][i] == 0) {
                        graph[idx][i] = cur;
                    } else if (graph[idx][i] == cur) {
                        graph[idx][i] *= 2;
                        idx++;
                    }else{
                        idx++;
                        graph[idx][i] = cur;
                    }
                }
            }
        }
        else {
                for (int i = 0; i < N; i++) {
                for (int j = N-1; j >= 0; j--) {
                    if (graph[j][i] != 0) {
                        q.add(graph[j][i]);
                        graph[j][i] = 0;
                    }
                }
                int idx = N - 1;
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    if (graph[idx][i] == 0) {
                        graph[idx][i] = cur;
                    } else if (graph[idx][i] == cur) {
                        graph[idx][i] *= 2;
                        idx--;
                    }else{
                        idx--;
                        graph[idx][i] = cur;
                    }
                }
            }
        }
    }
}
