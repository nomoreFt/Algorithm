import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int num = 0;
            int result = 0;
            while (true) {
                num = num * 10 + 1;
                num %= N;
                result++;
                if (num == 0) {
                    System.out.println(result);
                    break;
                }
            }
        }
        }
    }


