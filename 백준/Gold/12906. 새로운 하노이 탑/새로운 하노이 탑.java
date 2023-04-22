import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = new String[3];
        for (int i = 0; i < 3; i++) {
            int cnt = sc.nextInt();
            if (cnt > 0) {
                s[i] = sc.next();
            }else{
                s[i] = "";
            }
        }

        //최종 형태

        int[] cnt = {0, 0, 0};
        for (String str : s) {
            for (char ch : str.toCharArray()) {
                cnt[ch - 'A']++;
            }
        }
        HashMap<List<String>, Integer> dist = new HashMap<>();
        Queue<List<String>> q = new LinkedList<>();
        q.offer(Arrays.asList(s));
        dist.put(Arrays.asList(s), 0);
        while (!q.isEmpty()) {
            String[] now = q.poll().toArray(new String[3]);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i==j) continue;
                    if(now[i].length() == 0) continue;
                    String[] next = {now[0], now[1], now[2]};
                    next[j] += next[i].charAt(next[i].length() - 1);
                    next[i] = next[i].substring(0, next[i].length() - 1);
                    List<String> key = Arrays.asList(next);
                    if (dist.containsKey(key) == false) {
                        dist.put(key, dist.get(Arrays.asList(now)) + 1);
                        q.offer(Arrays.asList(next));
                    }
                }
            }
        }

        String[] temp = {"A", "B", "C"};
        String[] ans = new String[3];
        for (int i = 0; i < 3; i++) {
            ans[i] = "";
            for (int j = 0; j < cnt[i]; j++) {
                ans[i] += temp[i];
            }
        }
        System.out.println(dist.get(Arrays.asList(ans)));
    }
}