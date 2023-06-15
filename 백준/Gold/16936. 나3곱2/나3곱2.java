import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] A = new long[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }

        List<Long> collect = Arrays.stream(A).boxed().collect(Collectors.toList());
        collect.sort(new Comparator<Long>(){

            @Override
            public int compare(Long o1, Long o2) {
                int o1Cnt = countDivisibleBy3(o1);
                int o2Cnt = countDivisibleBy3(o2);

                if(o1Cnt <o2Cnt) {
                    return 1;
                }else if(o1Cnt > o2Cnt) {
                    return -1;
                }else {
                    return o1.compareTo(o2);
                }
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.print(collect.get(i) + " ");
        }
    }

    private static int countDivisibleBy3(Long n) {
        int count = 0;
        while (n % 3 == 0) {
            count++;
            n /= 3;
        }
        return count;
    }
}

