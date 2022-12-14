import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Main {
    static int k;
    static String[] budeung;
    static boolean[] visited = new boolean[10];

    static ArrayList<String> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        budeung = br.readLine().split(" ");

        dfs(0,"");

        Collections.sort(ans);
        System.out.println(ans.get(ans.size()-1));
        System.out.println(ans.get(0));
    }

    static void dfs(int idx,String num) {
        if (idx == k+1) {
            ans.add(num);
            return;
        }
        if(idx > k+1) return;
        for (int i = 0; i <= 9; i++) {
            if(visited[i]) continue;
            if (idx == 0 || ok(num.charAt(idx - 1) - '0', i, budeung[idx - 1])) {
            visited[i] = true;
            dfs(idx + 1, num + Integer.toString(i));
            visited[i] = false;
            }
        }
    }

    private static boolean ok(int i, int i1, String s) {
        if (s.equals("<")) {
            if(i > i1) return false;
        }
        if (s.equals(">")) {
            if(i < i1) return false;
        }
        return true;
    }
}

