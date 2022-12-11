import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int prevValue = 1%N;
            for (int i = 1; ; i++) {
                if(prevValue == 0){
                    System.out.println(i);
                    break;
                }
                prevValue = (prevValue*10 +1)%N;
            }
        }
    }
}