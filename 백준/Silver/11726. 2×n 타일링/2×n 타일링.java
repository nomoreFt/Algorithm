import java.io.*;

public class Main{
    static int n;
    static int[] d;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        d = new int[1001];
        System.out.println(dp(n));
    }   
    static int dp(int x){
        if(x==1) return 1;
        if(x==2) return 2;
        if(d[x] != 0) return d[x];
        return d[x] = (dp(x-1) + dp(x-2)) % 10007;
    }
}