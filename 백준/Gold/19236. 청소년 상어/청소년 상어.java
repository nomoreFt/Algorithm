import java.util.*;

public class Main {
    //fish 번호, 방향
    public static class Shark{
        int x;
        int y;
        int dir;
        public Shark(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    public static class Fish{
        int dir;
        int idx;
        public Fish(int idx, int dir) {
            this.idx = idx;
            this.dir = dir;
        }
    }
    //반시계 45도 dx dy
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fish[][] fishBoard = new Fish[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt()-1;
                fishBoard[i][j] = new Fish(a,b);
            }
        }

        //물고기 이동

        Fish fish = fishBoard[0][0];
        max += fish.idx;
        fishBoard[0][0] = new Fish(0,0);
        solution(fishBoard,new Shark(0,0,fish.dir),fish.idx);

        System.out.println(max);
    }
    private static void moveFish(Fish[][] fishBoard,Shark now) {
        for (int fish = 1; fish <= 16; fish++) {
            boolean isChange = false;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (fishBoard[i][j].idx == fish) {
                        for (int k = 0; k < 8; k++) {
                            int nX = i + dx[(fishBoard[i][j].dir+k)%8];
                            int nY = j + dy[(fishBoard[i][j].dir+k)%8];
                            if(nX < 0 || nX >= 4 || nY < 0 || nY >= 4) continue;
                            if(nX == now.x && nY == now.y ) continue;

                            Fish temp = fishBoard[i][j];
                            temp.dir = (fishBoard[i][j].dir+k)%8;
                            fishBoard[i][j] = fishBoard[nX][nY];
                            fishBoard[nX][nY] = temp;
                            isChange = true;
                            break;
                        }
                    }
                    if(isChange) break;
                }
                if(isChange) break;
            }
        }
    }
    private static void solution(Fish[][] fishBoard, Shark now, int cur){
        moveFish(fishBoard,now);

        int nX = now.x + dx[now.dir];
        int nY = now.y + dy[now.dir];
        while(0 <= nX && nX < 4 && 0 <= nY && nY < 4){
            if (fishBoard[nX][nY].idx != 0) {
                Fish temp = fishBoard[nX][nY];
                fishBoard[nX][nY] = new Fish(0,0);
                int value = cur +temp.idx;
                max = Math.max(max, value);
                solution(copyFishBoard(fishBoard), new Shark(nX,nY,temp.dir), value);
                fishBoard[nX][nY] = temp;
            }
            nX += dx[now.dir];
            nY += dy[now.dir];
        }

    }

    private static Fish[][] copyFishBoard(Fish[][] origin) {
        Fish[][] copy = new Fish[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copy[i][j] = new Fish(origin[i][j].idx, origin[i][j].dir);
            }
        }
        return copy;
    }


}
