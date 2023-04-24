import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int n;
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        t = Integer.parseInt(br.readLine());
        boolean[][] palindrom = new boolean[n][n];
        //1개일때
        for (int i = 0; i < n; i++) {
            palindrom[i][i] = true;
        }
        //2개일때
        for (int i = 0; i < n - 1; i++) {
            if(arr[i] == arr[i+1]) palindrom[i][i+1] = true;
        }

        //3개이상일때
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k+1; i++) {
                    palindrom[i][i+k-1] = checkPalindrome(arr, i, i+k-1);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]) -1;
            int end = Integer.parseInt(input[1]) -1;
            sb.append(palindrom[start][end] ? 1 : 0).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static boolean checkPalindrome(int[] arr, int startIdx, int endIdx) {
        int start = startIdx;
        int end = endIdx;
        while(start < end){
            if(arr[start] != arr[end]){
                return false;
            }
                start++;
                end--;
        }
        return true;
    }
}