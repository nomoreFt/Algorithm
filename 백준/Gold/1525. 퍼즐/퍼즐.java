import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static String target = "123456780";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<String> q = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            String[] strs = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                sb.append(strs[j]);
            }
        }

        if (sb.toString().equals(target)) {
            System.out.println(0);
            return;
        } else {
            map.put(sb.toString(), 0);
            q.offer(sb.toString());
            System.out.println(bfs(q, map));
        }
    }

    public static int bfs(Queue<String> q, HashMap<String, Integer> map) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!q.isEmpty()) {

            String now = q.poll();
            int zero = now.indexOf('0');
            int zeroX = zero / 3;
            int zeroY = zero % 3;

            for (int i = 0; i < 4; i++) {
                int nextX = zeroX + dx[i];
                int nextY = zeroY + dy[i];

                if (nextX < 0 || nextX >= 3 || nextY < 0 || nextY >= 3) continue;

                int next = nextX * 3 + nextY;
                StringBuilder sb = new StringBuilder(now);
                char temp = sb.charAt(next);
                sb.setCharAt(next, '0');
                sb.setCharAt(zero, temp);

                if (sb.toString().equals(target)) return map.get(now) + 1;

                if (!map.containsKey(sb.toString())) {
                    map.put(sb.toString(), map.get(now) + 1);
                    q.offer(sb.toString());
                }
            }
        }
        return -1;
    }
}

