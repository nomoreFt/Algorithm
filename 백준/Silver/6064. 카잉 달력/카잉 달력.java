import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            String[] s = br.readLine().split(" ");
            int M = Integer.parseInt(s[0]);
            int N = Integer.parseInt(s[1]);
            int x = Integer.parseInt(s[2])-1;
            int y = Integer.parseInt(s[3])-1;

            boolean flag = false;
            for (int i = x; i < (N * M); i += M) {
                if (i % N == y) {
                    System.out.println(i+1);
                    flag = true;
                    break;
                }
            }
            if(!flag) System.out.println(-1);

        }

    }

}

