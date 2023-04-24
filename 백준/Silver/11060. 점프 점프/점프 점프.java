import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static int[] A;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        for (int i = 0; i < n; i++) {
            if(dist[i] == -1) continue;
            for (int j = 1; j <= A[i]; j++) {
                if (i + j < n) {
                    if (dist[i + j] == -1 || dist[i + j] > dist[i] + 1) {
                        dist[i+j] = dist[i] + 1;
                    }
                }
            }
        }

        System.out.println(dist[n-1]);


    }
}


