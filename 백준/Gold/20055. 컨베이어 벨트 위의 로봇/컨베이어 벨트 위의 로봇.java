import java.io.*;
import java.util.*;


class Main {
    static int N, K;
    static int[] belt;
    static boolean[] robot;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        belt = new int[2 * N];
        robot = new boolean[N];
        for(int i = 0; i < 2 * N; i++){
            belt[i] = sc.nextInt();
        }
        int T = 0;
        while (true) {
            T++;

            //1.벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            int[] beltCopy = belt.clone();

            for (int i = 0; i < 2 * N; i++) {
                int target = (i + 1) % (2 * N);
                belt[target] = beltCopy[i];
            }

            boolean[] robotCopy = robot.clone();
            for (int i = 0; i < N-1; i++) {
                if(i == 0){
                    robot[i] = false;
                }
                robot[i + 1] = robotCopy[i];
            }

            //2. 가장 먼저 벨트에 올라간 로봇부터 한 칸 이동
            //칸 내구도 1 이상 && 앞에 로봇 X
            for (int i = N - 1; i >= 0; i--) {
                if (i == N - 1) {
                    if(robot[N-1]){
                        robot[N-1] = false;//내림
                    }
                    continue;
                }
                if (!robot[i + 1] && belt[i + 1] != 0) {
                    if (robot[i]) {
                        boolean temp = robot[i];
                        robot[i] = false;
                        robot[i + 1] = temp;
                        belt[i + 1] -= 1;
                    }
                }
            }

            //3.올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 칸에 로봇 올린다.
            if (belt[0] != 0) {
                robot[0] = true;
                belt[0] -= 1;
            }

            //4.내구도 0인 칸의 개수 K개 이상인지 체크
            int cnt = 0;
            for (int i = 0; i < N * 2; i++) {
                if (belt[i] == 0) cnt++;
            }
            if (cnt >= K) break;

        }
        System.out.println(T);
    }
}