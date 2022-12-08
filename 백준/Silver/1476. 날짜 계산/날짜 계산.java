import java.io.*;
import java.util.Arrays;

class Main {
    static int E,S,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        E = Integer.parseInt(strs[0])-1;
        S = Integer.parseInt(strs[1])-1;
        M = Integer.parseInt(strs[2])-1;

        for (int i = 0; ; i++) {
            if (i%15 == E && i % 28 == S && i % 19 == M) {
                System.out.println(i+1);
                break;
            }
        }
    }
}



