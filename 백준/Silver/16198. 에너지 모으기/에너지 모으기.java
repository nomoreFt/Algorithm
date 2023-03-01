import java.io.*;
import java.util.*;


class Main {
    static int N;
    static ArrayList<Integer> W = new ArrayList<>();
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            W.add(sc.nextInt());
        }

        go(0, W);
        System.out.println(ans);
    }

    private static void go(int sum, ArrayList<Integer> w) {
        int size = w.size();
        if (size == 2) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 1; i < size - 1; i++) {
            int temp = w.get(i);
            int sumTemp = w.get(i - 1) * w.get(i + 1);
            w.remove(i);
            go(sum + sumTemp, w);
            w.add(i,temp);
        }

    }
}