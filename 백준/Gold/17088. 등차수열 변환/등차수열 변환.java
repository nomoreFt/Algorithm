import org.w3c.dom.Node;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (N == 1) {
            System.out.println(0);
            System.exit(0);
        }

        int ans = -1;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int change = 0;
                if(i != 0) change++;
                if(j != 0) change++;
                int num1 = arr[1] + i;
                int num0 = arr[0] + j;

                //합의된 등차
                int diff = num1 - num0;

                boolean ok = true;
                int target = num0 + diff; //[0]번 + 선택한 등차 = [1]번
                for (int k = 2; k < N; k++) {
                    target += diff; // [1]번 + 등차 = 2번 이후 계속 진행

                    if (arr[k] + 1 == target) {
                        change++;
                    } else if (arr[k] - 1 == target) {
                        change++;
                    } else if (arr[k] == target) {
                        continue;
                    }else{
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    if (ans == -1 || ans > change) {
                        ans = change;
                    }
                }
            }
        }
        System.out.println(ans);

    }
}

