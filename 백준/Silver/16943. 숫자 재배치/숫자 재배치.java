import java.util.*;

public class Main {
    static int A;
    static int B;
    static int MAX = -1;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();

        String[] split = String.valueOf(A).split("");
        visited = new boolean[split.length];

        go(split, 0,"");

        System.out.println(MAX);

    }

    static void go(String[] split, int idx, String sum) {
        if (idx == split.length) {
            if(Integer.parseInt(sum) <= B)
            MAX = Math.max(MAX, Integer.parseInt(sum));
        }

        for(int i = 0; i < split.length; i++) {
            if(visited[i]) continue;
            if(idx == 0 && split[i].equals("0")) continue;
            visited[i] = true;
            go(split, idx + 1, sum + split[i]);
            visited[i] = false;
        }
    }


}

