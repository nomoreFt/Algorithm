import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질3 문제 - 13549번
class Human {
    int x;
    int time;

    public Human(int x, int time) {
        this.x = x;
        this.time = time;
    }
}

public class Main {

    static int N, K;
    static int time = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K){
            System.out.println(0);
        }else {
            bfs(N);
            System.out.println(time);
        }
    }

    static void bfs(int start) {
        Queue<Human> q = new LinkedList<>();
        q.offer(new Human(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Human now = q.poll();

            if(now.x == K) {
                time = Math.min(time, now.time);
            }

            int next;
            // 다음에서 영역을 방문 처리
            // *2의 경우 time 이 증가하지 않으므로 다른 이동보다 먼저 계산되어야함.
            next = now.x * 2;
            if(next < 100001 && !visited[next]) {
                visited[next] = true;
                q.offer(new Human(next, now.time));
            }

            next = now.x - 1;
            if(next >= 0 && !visited[next]) {
                visited[next] = true;
                q.offer(new Human(next, now.time + 1));
            }

            next = now.x + 1;
            if(next < 100001 && !visited[next]) {
                visited[next] = true;
                q.offer(new Human(next, now.time + 1));
            }
        }
    }
}