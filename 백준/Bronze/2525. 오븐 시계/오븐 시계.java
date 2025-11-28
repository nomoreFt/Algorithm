
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //공백으로 split 해서 int로 변환
        int[] split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = split[0];
        int b = split[1];
        int c = Integer.parseInt(br.readLine());

        System.out.println(calculate(a, b, c));

    }

    private static String calculate(int time, int minute, int addMinute) {
        int result = minute + addMinute;

        int upTime = (time + (result / 60)) % 24;
        int lastMinute = result % 60;

        return String.format("%d %d", upTime, lastMinute);
    }

}