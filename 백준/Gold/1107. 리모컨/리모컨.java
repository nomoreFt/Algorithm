import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer> brokenBtns = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            brokenBtns.add(sc.nextInt());
        }

        int min = Math.abs(N - 100);

        for (int i = 0; i <= 999999; i++) {
            if (M != 0 && isBroken(brokenBtns, i)) {
                continue;
            }
            String str = String.valueOf(i);
            int len = str.length();

            min = Math.min(min, Math.abs(N - i) + len);
        }
        System.out.println(min);
        }
    private static boolean isBroken(ArrayList<Integer> brokenBtns, int i) {
      return brokenBtns.stream().anyMatch(integer -> String.valueOf(i).contains(String.valueOf(integer)));
    }
}

