import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int n;
    static int t;
    static int[][] palindrom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        t = Integer.parseInt(br.readLine());
        palindrom = new int[n][n];

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String[] input  = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            sb.append(go(arr, start - 1, end - 1)).append("\n");
        }
        System.out.println(sb.toString());

    }
    static int go(int[] arr,int start, int end) {
        if (start == end) {
            return 1;
        }
        if (start + 1 == end) {
            if(arr[start] == arr[end]){
                return 1;
            }else{
                return 0;
            }
        }
        if(palindrom[start][end] == 1){
            return 1;
        }
        if(arr[start] != arr[end]){
            return 0;
        }else{
            return palindrom[start][end] = go(arr, start + 1, end - 1);
        }
    }
}