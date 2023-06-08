import java.io.*;
import java.util.*;

public class Main {
    static class Smell{
        int idx;
        int time;

        public Smell(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
    static class Shark{
        int dir;
        int idx;
        public Shark(int idx, int dir) {
            this.idx = idx;
            this.dir = dir;
        }
    }
    static int N,M,k;
    static Shark[][] sharkGraph;
    static Smell[][] smellGraph;
    //상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][][] priorityDir;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);//냄새 제한
        priorityDir = new int[M][4][4];
        //상어 그래프
        sharkGraph = new Shark[N][N];
        //냄새 그래프
        smellGraph = new Smell[N][N];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int shark = Integer.parseInt(input[j]);
                if (shark != 0) {
                    sharkGraph[i][j] = new Shark(shark-1,0);
                }
            }
        }
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sharkGraph[i][j] != null) {
                    for (int k = 0; k < M; k++) {
                        if(sharkGraph[i][j].idx == k){
                            sharkGraph[i][j].dir = Integer.parseInt(input[k])-1;
                        }
                    }
                }
            }
        }

        for (int k = 0; k < M; k++) {
            for (int i = 0; i < 4; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < 4; j++) {
                    priorityDir[k][i][j] = Integer.parseInt(input[j])-1;
                }
            }
        }


        for (int T = 1; T <= 1000; T++) {
            boolean onlyOne = solution();
            if (onlyOne) {
                System.out.println(T);
                return;
            }
        }
        System.out.println(-1);
    }

    private static void spreadSmell(){

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sharkGraph[i][j] != null) {
                    smellGraph[i][j] = new Smell(sharkGraph[i][j].idx, k);

                }
            }

        }


    }

    private static void discountSmellTime() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (smellGraph[i][j] != null) {
                    smellGraph[i][j].time -= 1;
                    if(smellGraph[i][j].time <= 0) smellGraph[i][j] = null;
                }
            }
        }
    }
    private static void moveShark() {
        Shark[][] temp = new Shark[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sharkGraph[i][j] != null) {
                    Shark now = sharkGraph[i][j];
                    int nowX = i;
                    int nowY = j;
                    int[] prioritySharkDir = priorityDir[now.idx][now.dir];
                    boolean canGo = false;
                    //상어 방향에 따른 우선순위 방향으로 이동할 공간이 있으면 이동
                    for (int k = 0; k < 4; k++) {
                        int nX = nowX + dx[prioritySharkDir[k]];
                        int nY = nowY + dy[prioritySharkDir[k]];

                        if(nX < 0 || nX >= N || nY < 0 || nY >= N) continue;
                        if(smellGraph[nX][nY] != null) continue;
                        canGo = true;
                        //방향 이동
                        if (temp[nX][nY] != null) {
                            //옮기려는 장소에 있는 상어보다 idx가 작으면 먹음
                            if(temp[nX][nY].idx > now.idx){
                                temp[nX][nY] =   new Shark(now.idx, prioritySharkDir[k]);
                            }
                            //우선순위가 작으면 못먹고 그냥 사라짐
                        }else{
                            //옮기려는 장소가 비어있으면 그냥 상어 등록
                            temp[nX][nY] =   new Shark(now.idx, prioritySharkDir[k]);
                        }
                        sharkGraph[i][j] = null;
                        break;
                    }
                    //이동할 공간이 없으면 자기 냄새 방향 체크
                    if(!canGo){
                        for (int k = 0; k < 4; k++) {
                            int nX = nowX + dx[prioritySharkDir[k]];
                            int nY = nowY + dy[prioritySharkDir[k]];

                            if(nX < 0 || nX >= N || nY < 0 || nY >= N) continue;
                            if(smellGraph[nX][nY] != null){
                                Smell nowSmell = smellGraph[nX][nY];
                                if (nowSmell.idx == now.idx) {
                                    if (temp[nX][nY] != null) {
                                        if (temp[nX][nY].idx > now.idx) {
                                            temp[nX][nY] = new Shark(now.idx, prioritySharkDir[k]);
                                        }
                                    }else{
                                        temp[nX][nY] = new Shark(now.idx, prioritySharkDir[k]);
                                    }
                                    sharkGraph[i][j] = null;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        //상어 temp이동그래프 -> sharkGraph로 이식
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(temp[i][j] != null) sharkGraph[i][j] = temp[i][j];
            }
        }

    }

    private static boolean checkOnlyOne() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(sharkGraph[i][j] != null){
                    cnt++;
                }
            }
        }
        return cnt == 1;
    }
    private static boolean solution(){
        boolean onlyOne = false;

         spreadSmell();
        moveShark();
        discountSmellTime();
     //   printSmell();
       // printShark();
        //상어가 한마리 남았나 체크
        onlyOne = checkOnlyOne();
        return onlyOne;
    }

    private static void printSmell(){
        System.out.println("smell =======================");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (smellGraph[i][j] != null) {
                    System.out.print(i+","+j+"("+smellGraph[i][j].idx+","+smellGraph[i][j].time +") /");
                }else{
                    System.out.print(i+","+j+"(null) /");
                }
            }
            System.out.println();
        }
        System.out.println("=================================");
    }
    private static void printShark(){
        System.out.println("shark =======================");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sharkGraph[i][j] != null) {
                    System.out.print(i+","+j+"("+sharkGraph[i][j].idx+","+sharkGraph[i][j].dir +") /");
                }else{
                    System.out.print(i+","+j+"(null) /");
                }
            }
            System.out.println();
        }
        System.out.println("=================================");
    }
}
