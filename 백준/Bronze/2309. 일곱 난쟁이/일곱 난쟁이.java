import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static int DwarfCnt = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[DwarfCnt];
        int sum = 0;
        for (int i = 0; i < DwarfCnt; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < DwarfCnt; i++) {
            for (int j = i + 1; j < DwarfCnt; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    printAnswer(arr,i, j);
                    return;
                }
            }
        }
    }
    private static void printAnswer(int[] arr, int i, int j) {
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < DwarfCnt; t++) {
            if(t == i || t == j) continue;
            sb.append(arr[t] + "\n");
        }
        System.out.println(sb.toString());
    }
}