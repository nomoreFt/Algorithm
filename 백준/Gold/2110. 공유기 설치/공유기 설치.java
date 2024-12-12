import java.io.*;
import java.util.*;

class Main {
    static int N, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        N = Integer.parseInt(strs[0]);
        C = Integer.parseInt(strs[1]);
        ArrayList<Integer> list = new ArrayList<>();
        for(long i = 0; i < N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        int low = 1;//공유기 설치 최소 거리
        int high = list.get(N-1) - list.get(0);//공유기 설치 최대 거리
        int result = 0;

        while(low <= high){
            int mid = (low + high) / 2;
            if(checking(list, mid, C)) {
                result = Math.max(result, mid);
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static boolean checking(ArrayList<Integer> list, int mid, int routerCnt) {
        int cnt = 1;
        int last = list.get(0);
        for(int i = 1; i < N; i++){
            if(list.get(i) - last >= mid){
                cnt++;
                last = list.get(i);
            }
            if(cnt >= routerCnt) return true;
        }
        
        return false;
    }
}