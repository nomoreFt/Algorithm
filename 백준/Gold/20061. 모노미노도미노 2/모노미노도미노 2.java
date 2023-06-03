import java.util.*;

public class Main {
    static boolean[][] BLUEBOARD = new boolean[4][6];
    static boolean[][] GREENBOARD = new boolean[6][4];
    static int point = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int type = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            setBlock(type,x,y);
            while(checkPoint()){
                checkPoint();
            };//점수 +1, 칸 삭제
            checkOverBlock();//연한칸 블록 미루기
        }
        System.out.println(point);
        int tileSum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                if(BLUEBOARD[i][j]) tileSum++;
                if(GREENBOARD[j][i]) tileSum++;
            }
        }
        System.out.println(tileSum);
    }

    private static void checkOverBlock() {
        if (BLUEBOARD[0][0] || BLUEBOARD[1][0] || BLUEBOARD[2][0] || BLUEBOARD[3][0]) {
            downBlue(5);
            BLUEBOARD[0][0] = BLUEBOARD[1][0] = BLUEBOARD[2][0] = BLUEBOARD[3][0] = false;
        }

        if (GREENBOARD[0][0] || GREENBOARD[0][1] || GREENBOARD[0][2] || GREENBOARD[0][3]) {
            downGreen(5);
            GREENBOARD[0][0] = GREENBOARD[0][1] = GREENBOARD[0][2] = GREENBOARD[0][3] = false;
        }

        if (BLUEBOARD[0][1] || BLUEBOARD[1][1] || BLUEBOARD[2][1] || BLUEBOARD[3][1]) {
            downBlue(5);
            BLUEBOARD[0][1] = BLUEBOARD[1][1] = BLUEBOARD[2][1] = BLUEBOARD[3][1] = false;
        }

        if (GREENBOARD[1][0] || GREENBOARD[1][1] || GREENBOARD[1][2] || GREENBOARD[1][3]) {
            downGreen(5);
            GREENBOARD[1][0] = GREENBOARD[1][1] = GREENBOARD[1][2] = GREENBOARD[1][3] = false;
        }

    }

    private static boolean checkPoint() {
        boolean getPoint = false;
        for(int i = 5; i > 0; i--){
            if (BLUEBOARD[3][i] && BLUEBOARD[2][i] && BLUEBOARD[1][i] && BLUEBOARD[0][i]) {
                //지우기
                BLUEBOARD[3][i] = BLUEBOARD[2][i] = BLUEBOARD[1][i] = BLUEBOARD[0][i] = false;
                //포인트
                point++;
                //i윗줄 다 한칸씩 내리기
                downBlue(i);
                getPoint = true;
            }

            if (GREENBOARD[i][0] && GREENBOARD[i][1] && GREENBOARD[i][2] && GREENBOARD[i][3]) {
                GREENBOARD[i][0] = GREENBOARD[i][1] = GREENBOARD[i][2] = GREENBOARD[i][3] = false;
                point++;
                //윗줄 다 아래로 밀기
                downGreen(i);
                getPoint = true;
            }
        }
        return getPoint;
    }
    private static void downBlue(int targetY) {
        for (int j = targetY - 1; j >= 0; j--) {
            for (int i = 0; i < 4; i++) {
                BLUEBOARD[i][j+1] = BLUEBOARD[i][j];
            }
        }
    }

    private static void downGreen(int targetX) {
        for (int i = targetX - 1; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                GREENBOARD[i + 1][j] = GREENBOARD[i][j];
            }
        }
    }

    private static void setBlock(int type, int x, int y) {
        if(type == 1){
            setBLUE1(x);
            setGREEN1(y);
        }else if(type == 2){
            setBLUE1(x);
            setBLUE1(x);
            setGREEN2(y,y+1);
        }else if(type == 3){
            setBLUE3(x, x + 1);
            setGREEN1(y);
            setGREEN1(y);
        }
    }
    private static void setBLUE3(int x, int x2) {
        int nY = -1;
        for (int i = 0; i < 6; i++) {
            if (BLUEBOARD[x][i] || BLUEBOARD[x2][i]) {
                nY = i-1;
                break;
            }else{
                nY++;
            }
        }
        BLUEBOARD[x][nY] = BLUEBOARD[x2][nY] = true;
    }

    private static void setGREEN2(int y, int y2) {
        int nX = -1;
        for (int i = 0; i < 6; i++) {
            if (GREENBOARD[i][y] || GREENBOARD[i][y2]) {
                nX = i-1;
                break;
            }else{
                nX++;
            }
        }
        GREENBOARD[nX][y] = GREENBOARD[nX][y2] = true;
    }

    private static void setGREEN1(int y) {
        int nY;
        int nX;
        nX = -1;
        nY = y;
        for (int i = 0; i < 6; i++) {
            if(GREENBOARD[i][nY]){
                nX = i-1;
                break;
            }else{
                nX++;
            }
        }
        GREENBOARD[nX][nY] = true;
    }

    private static void setBLUE1(int x) {
        int nX = x;
        int nY = -1;
        for (int j = 0; j < 6; j++) {
            if (BLUEBOARD[nX][j]) {
                nY = j-1;
                break;
            }else{
                nY++;
            }
        }
        BLUEBOARD[nX][nY] = true;
    }
}
