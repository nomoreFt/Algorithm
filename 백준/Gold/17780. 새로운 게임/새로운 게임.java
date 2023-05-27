import java.util.*;

public class Main {
    static int[][] board;
    static final int WHITE = 0;
    static final int RED = 1;
    static final int BLUE = 2;

    static ArrayList<Pawn>[][] pawnGraph;
    static Pawn[] pawnList;
    static int N,K;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static class Pawn{
        int x;
        int y;
        int dir;
        int idx;
        public Pawn(int x, int y,int dir,int idx) {
            this.x = x;
            this.y = y;
        this.dir = dir;
        this.idx = idx;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        board = new int[N][N];
        pawnGraph = new ArrayList[N][N];
        pawnList = new Pawn[K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
                pawnGraph[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < K; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            int dir = sc.nextInt()-1;

            pawnGraph[x][y].add(new Pawn(x,y,dir,i));
            pawnList[i] = (new Pawn(x, y, dir,i));
        }


        for (int i = 1; i <= 1000; i++) {
            movePawn(i);
        }
        System.out.println(-1);
    }

    public static void movePawn(int T) {
        for (int k = 0; k < K; k++) {
            int x = pawnList[k].x;
            int y = pawnList[k].y;
            if (pawnGraph[x][y].get(0).idx != k) continue;

            int dir = pawnGraph[x][y].get(0).dir;
            int nX = x + dx[dir];
            int nY = y + dy[dir];


            if(0<=nX && nX < N && 0<=nY && nY < N){
                if(board[nX][nY] == BLUE) {
                    pawnGraph[x][y].get(0).dir = opponent(dir);
                }
            }else{
                pawnGraph[x][y].get(0).dir = opponent(dir);
            }

            dir = pawnGraph[x][y].get(0).dir;
            nX = x + dx[dir];
            nY = y + dy[dir];

            if(0<=nX && nX < N && 0<=nY && nY < N){
                if(board[nX][nY] == WHITE){
                    ArrayList<Pawn> temp = new ArrayList<>(pawnGraph[x][y]);
                    pawnGraph[x][y].clear();
                    for (Pawn p : temp) {
                        p.x = nX;
                        p.y = nY;
                        pawnGraph[nX][nY].add(p);
                        pawnList[p.idx] = p;
                    }

                }else if(board[nX][nY] == RED){
                    ArrayList<Pawn> temp = new ArrayList<>(pawnGraph[x][y]);
                    Collections.reverse(temp);
                    pawnGraph[x][y].clear();
                    for (Pawn p : temp) {
                        p.x = nX;
                        p.y = nY;
                        pawnGraph[nX][nY].add(p);
                        pawnList[p.idx] = p;
                    }

                }
                if (pawnGraph[nX][nY].size() >= 4) {
                    System.out.println(T);
                    System.exit(0);
                }
            }else{
                continue;
            }
        }


    }

    public static int opponent(int dir){
        if(dir ==  0) return 1;
        else if(dir == 1) return 0;
        else if(dir == 2) return 3;
        else  return 2;
    }
}

