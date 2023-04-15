import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static long s,t;
    final static long LIMIT = 1000000000L;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        s = sc.nextLong();
        t = sc.nextLong();

        if (s == t) {
            System.out.println(0);
            return;
        }


        Queue<Long> q = new LinkedList<>();
        Queue<String> qs = new LinkedList<>();
        HashSet<Long> check = new HashSet<>();

        q.offer(s);
        qs.offer("");
        check.add(s);
        while (!q.isEmpty()) {
            long now = q.poll();
            String nows = qs.poll();

            if (now == t) {
                System.out.println(nows);
                return;
            }
            long next = now * now;
            if (0 <= next && next <= LIMIT && !check.contains(next)) {
                q.offer(next);
                qs.offer(nows + "*");
                check.add(next);
            }
            next = now * 2;
            if (0 <= next && next <= LIMIT && !check.contains(next)) {
                q.offer(next);
                qs.offer(nows + "+");
                check.add(next);
            }
            next = now - now;
            if (0 <= next && next <= LIMIT && !check.contains(next)) {
                q.offer(next);
                qs.offer(nows + "-");
                check.add(next);
            }
            if (now != 0 && 0 <= (now / now) && (now / now) <= LIMIT && !check.contains(now / now)) {
                q.offer(now / now);
                qs.offer(nows + "/");
                check.add(now / now);
            }
        }
        System.out.println(-1);
    }


}

