import java.io.*;
import java.util.*;

public class Main {
        static int k;
        static int[] output;
        static boolean[] visited;
        static String[] exp;
    static ArrayList<String> resultArr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         k = Integer.parseInt(br.readLine());
            output = new int[k+1];
        exp = new String[k];
        visited = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            exp[i] = st.nextToken();
        }
        for (int i = 0; i <= 9; i++) {
            visited[i] = true;
            dfs(0,i+"");
            visited[i] = false;
        }
        Collections.sort(resultArr);
        System.out.println(resultArr.get(resultArr.size() - 1));
        System.out.println(resultArr.get(0));
        }

    static void dfs(int depth, String now) {
        if (depth == k) {
            if (isValid(now)) {
                resultArr.add(now);
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, now + i);
                visited[i] = false;
            }
        }
    }

    private static boolean isValid(String now) {
        for (int i = 0; i < k; i++) {
                if (exp[i].equals("<")) {
                    if (now.charAt(i) > now.charAt(i + 1)) {
                        return false;
                    }
                } else {
                    if (now.charAt(i) < now.charAt(i + 1)) {
                        return false;
                    }
            }
        }
        return true;
    }

    }

