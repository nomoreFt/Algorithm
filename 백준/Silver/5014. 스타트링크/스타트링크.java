import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static long topFloor,start,target,u,d;
    static long[] dist = new long[1000001];
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        topFloor = sc.nextInt();
        start = sc.nextInt();
        target = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();

        Arrays.fill(dist,-1);

        Queue<Long> q = new LinkedList<>();
        q.offer(start);
        dist[(int) start] = 0;
        while (!q.isEmpty()) {
            long now = q.poll();

            long next = now + u;

            if (0 < next && next <= topFloor) {
                if (dist[(int) next] == -1) {
                    dist[(int) next] = dist[(int) now]+1;
                    q.offer(next);
                }
            }

            next = now - d;
            if (0 < next && next <= topFloor) {
                if (dist[(int) next] == -1) {
                    dist[(int) next] = dist[(int) now]+1;
                    q.offer(next);
                }
            }
        }

        if (dist[(int)target] == -1) {
            System.out.println("use the stairs");
        }else{
            System.out.println(dist[(int)target]);
        }
    }
}

