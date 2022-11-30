import java.io.*;
import java.util.*;
public class Main {
    static final int MAX = 105;
    static int H, W;
	
    static int ay[] = {-1,1,0,0};
    static int ax[] = {0,0,-1,1};
	
    static char map[][];
    static int open[][];
    static boolean visit[][];	
    
    static class xy {
        int y, x;
        xy(int y, int x) {
            this.y=y;
            this.x=x;
        }
    }
    static ArrayList<xy>slave=new ArrayList<xy>();
    static ArrayList<xy>key=new ArrayList<xy>();
	
    static class Data implements Comparable<Data>{
        int y, x, key;
        Data(int y, int x, int key) {
            this.y=y;
            this.x=x;
            this.key=key;
        }
        @Override
        public int compareTo(Data o) {
            return this.key - o.key;
        }
    }
    static void init() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H+2][W+2];
            open = new int[H+2][W+2];
            visit = new boolean[H+2][W+2];
            slave.clear();
            key.clear();
            for(char item[] : map)
                Arrays.fill(item, '.');
            for(int i=1;i<=H;i++) {
                char temp[] = br.readLine().toCharArray();
                for(int j=0;j<W;j++) {
                    map[i][j+1] = temp[j];
                    if (map[i][j+1] == '$')
                        slave.add(new xy(i, j+1));
                    if (map[i][j+1] == '#')
                        key.add(new xy(i, j+1));
                }
            }
            if (Move()) {
                System.out.println(0);
            }
            else {
                openMove(0, 0);
                for(int i=0;i<slave.size();i++)
                    openMove(slave.get(i).y, slave.get(i).x);
                solve();
            }
        }
    }
    static boolean Move() {
        int find=0;
        Queue<xy>q=new LinkedList<>();
        q.add(new xy(0, 0));
        while(!q.isEmpty()) {
            xy out = q.poll();
            if (map[out.y][out.x] =='$') {
                if(find==1)
                    return true;
                find++;
            }
            for(int i=0;i<4;i++) {
                int ny = out.y+ay[i];
                int nx = out.x+ax[i];
                if(!range(ny, nx) && map[ny][nx] != '#' && !visit[ny][nx]) {
                    visit[ny][nx] = true;
                    q.add(new xy(ny, nx));
                }
            }
        }
        return false;
    }
	static void openMove(int y, int x) {
        PriorityQueue<Data>q = new PriorityQueue<>();
        q.add(new Data(y, x, 0));
        for(boolean item[] : visit)
            Arrays.fill(item, false);
        visit[y][x] = true;
        while(!q.isEmpty()) {
            Data out = q.poll();
            for(int i=0;i<4;i++) {
                int ny = out.y+ay[i];
                int nx = out.x+ax[i];
                int nkey = out.key;
                if(!range(ny, nx) && !visit[ny][nx]) {
                    visit[ny][nx] = true;
                    if (map[ny][nx] == '#') {
                        nkey++;
                        open[ny][nx] += nkey;
                    }
                    q.add(new Data(ny, nx, nkey));
                }
            }
        }
    }
    static void solve() {
        int answer = Integer.MAX_VALUE;
        for(xy item : key)
            answer = Math.min(answer, open[item.y][item.x]);
        System.out.println(answer-2);
    }
    static boolean range(int y, int x) {
        return y<0||x<0||y>H+1||x>W+1||map[y][x]=='*';
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
    }
}