import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        int N = sc.nextInt();
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N - i; j++) {
                for (int k = 0; k <= N - i - j; k++) {
                    int l = N - i - j - k;
                    int sum = i + (5 * j) + (10*k)+(50*l);
                    set.add(sum);
                }
            }
        }
        System.out.println(set.size());


    }
}
