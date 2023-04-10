import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int n;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Fish extends Node{
        int dist;

        public Fish(int x, int y, int dist) {
            super(x, y);
            this.dist = dist;
        }
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] fishGraph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        fishGraph = new int[n][n];
        Node shark = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                fishGraph[i][j] = sc.nextInt();
                if (fishGraph[i][j] == 9) {
                    fishGraph[i][j] = 0;
                    shark = new Node(i, j);
                }
            }
        }


        int ans = 0;
        int sharkSize = 2;
        int exp = 0;

        while (true) {
            Fish fish = bfs(shark, sharkSize);//bfs로 다음 먹을 물고기 파악.
            if (fish == null) break;
            //물고기 먹고 빈칸처리
            fishGraph[fish.x][fish.y] = 0;
            //상어 위치 물고기위치로 수정
            shark.x = fish.x;
            shark.y = fish.y;
            //해당 물고기로 가는 칸 답에 추가
            ans += fish.dist;
            exp++;
            if (sharkSize == exp) {
                sharkSize++;
                exp = 0;
            }
        }
        System.out.println(ans);
    }

    public static Fish bfs(Node shark, int sharkSize) {

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        //먹을 수 있는 물고기
        ArrayList<Fish> fishList = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(shark);
        dist[shark.x][shark.y] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nX = now.x + dx[i];
                int nY = now.y + dy[i];

                //범위안에 들고 방문한 적이 없다면
                if (0 <= nX && nX < n && 0 <= nY && nY < n && dist[nX][nY] == -1) {
                    boolean ok = false;
                    boolean eat = false;
                    if (fishGraph[nX][nY] == 0) {
                        ok = true;
                    } else if (fishGraph[nX][nY] < sharkSize) {
                        ok = true;
                        eat = true;
                    } else if (fishGraph[nX][nY] == sharkSize) {
                        ok = true;
                    }

                    if (ok) {
                        q.offer(new Node(nX, nY));
                        dist[nX][nY] = dist[now.x][now.y] + 1;
                        if (eat) {
                            fishList.add(new Fish(nX, nY, dist[nX][nY]));
                        }
                    }
                }

            }
        }
        //fishList가 null이면 먹을게 없다.
        if (fishList.isEmpty()) return null;
        Fish best = fishList.get(0);
        for (Fish f : fishList) {
            if(f.dist < best.dist) best = f;
            else if(best.dist == f.dist && best.x > f.x) best = f;
            else if(best.dist == f.dist && best.x == f.x && best.y > f.y) best = f;
        }
        return best;
    }
}
