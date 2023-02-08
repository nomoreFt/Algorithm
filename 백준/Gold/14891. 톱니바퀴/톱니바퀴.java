import java.io.*;
import java.sql.Array;
import java.util.*;


class Main {
    static int T,K;
    static int graph[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = 4;
        graph = new int[T][8];
        for (int i = 0; i < T; i++) {
            String[] strs = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                graph[i][j] = Integer.parseInt(strs[j]);
            }
        }

        K = Integer.parseInt(br.readLine());

        //N극은 0, S극은 1
        //1 시계방향 -1 반시계방향

        for (int cycle = 0; cycle < K; cycle++) {
            String[] strs = br.readLine().split(" ");
            int target = Integer.parseInt(strs[0])-1;
            int dir = Integer.parseInt(strs[1]);

            //좌우 살펴서 돌릴 톱니바퀴 체크
            ArrayList<Gear> willSwitch = new ArrayList<>();
            willSwitch.add(new Gear(target, dir));

            //왼쪽 체크
            int tempDir = dir;
            for (int i = target; i > 0; i--) {
                int right = graph[i][6];
                int left = graph[i-1][2];
                if(right != left){
                    tempDir = -tempDir;
                    willSwitch.add(new Gear(i - 1, tempDir));
                }else{
                    break;
                }
            }
            //오른쪽 체크
            tempDir = dir;
            for (int i = target; i < T-1; i++) {
                int left = graph[i][2];
                int right = graph[i+1][6];
                if(right != left){
                    tempDir = -tempDir;
                    willSwitch.add(new Gear(i + 1, tempDir));
                }else{
                    break;
                }
            }


            int size = willSwitch.size();
            for (int i = 0; i < size; i++) {
                Gear now = willSwitch.get(i);
                int nowIdx = now.idx;
                int[] temp = graph[nowIdx].clone();
                if (now.direction == -1) {//반시계방향
                    graph[nowIdx][7] = temp[0];
                    graph[nowIdx][6] = temp[7];
                    graph[nowIdx][5] = temp[6];
                    graph[nowIdx][4] = temp[5];
                    graph[nowIdx][3] = temp[4];
                    graph[nowIdx][2] = temp[3];
                    graph[nowIdx][1] = temp[2];
                    graph[nowIdx][0] = temp[1];
                }else{
                    graph[nowIdx][7] = temp[6];
                    graph[nowIdx][6] = temp[5];
                    graph[nowIdx][5] = temp[4];
                    graph[nowIdx][4] = temp[3];
                    graph[nowIdx][3] = temp[2];
                    graph[nowIdx][2] = temp[1];
                    graph[nowIdx][1] = temp[0];
                    graph[nowIdx][0] = temp[7];
                }
            }

        }

        int ans = 0;
        int go = 1;
        for (int i = 0; i < T; i++) {
            int[] ints = graph[i];
            ans += ints[0]*go;
            go = go*2;
        }
        System.out.println(ans);
    }

    public static class Gear {
        int idx;
        int direction;

        public Gear(int idx, int direction) {
            this.idx = idx;
            this.direction = direction;
        }
    }
}