import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        String[] strs = br.readLine().split(" ");

        int min = Arrays.stream(strs)
                .mapToInt(Integer::parseInt)
                .min().getAsInt();
        int max = Arrays.stream(strs)
                .mapToInt(Integer::parseInt)
                .max().getAsInt();

        System.out.println(min*max);
        }
    }


