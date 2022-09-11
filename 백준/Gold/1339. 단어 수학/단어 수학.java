import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<String> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(br.readLine());
        }
        int[] alpha = new int[26];

        for (int i = 0; i < N; i++) {
            int temp = (int) Math.pow(10, arr.get(i).length() - 1);
            for (int j = 0; j < arr.get(i).length(); j++) {
                alpha[arr.get(i).charAt(j) - 'A'] += temp;
                temp /= 10;
            }
        }

        Arrays.sort(alpha);
        int idx = 9;
        int sum = 0;
        for (int i = alpha.length - 1; i >= 0; i--) {
            if (alpha[i] == 0) {
                break;
            }
            sum += alpha[i] * idx;
            idx--;
        }
        System.out.println(sum);
    }

}
