import java.util.*;
import java.io.*;

class Main{
    public static ArrayList<Integer> arr = new ArrayList<Integer>();
    public static int N,Plus,Minus,Mul,Div;
    public static int Max = (int) -1e9;
    public static int Min = (int) 1e9;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        strs = br.readLine().split(" ");
        for(int i = 0; i < strs.length; i++){
            arr.add(Integer.parseInt(strs[i]));
        }
        strs = br.readLine().split(" ");
        Plus = Integer.parseInt(strs[0]);
        Minus = Integer.parseInt(strs[1]);
        Mul = Integer.parseInt(strs[2]);
        Div = Integer.parseInt(strs[3]);
        dfs(0,arr.get(0));
        System.out.println(Max);
        System.out.println(Min);
        
    }
    public static void dfs(int depth,int value){
        if(depth == N-1) {
            Max = Math.max(Max,value);
            Min = Math.min(Min,value);
        }
        if(Plus > 0){
            value += arr.get(depth+1);
            Plus = Plus-1;
            depth += 1;
            dfs(depth,value);
            Plus += 1;
            depth-=1;
            value -= arr.get(depth+1);
        } if(Minus > 0){
            value -= arr.get(depth+1);
            Minus = Minus-1;
            depth += 1;
            dfs(depth,value);
            depth -= 1;
            Minus += 1;
            value += arr.get(depth+1);
        } if(Mul > 0){
            value *= arr.get(depth+1);
            Mul = Mul-1;
            depth += 1;
            dfs(depth,value);
            depth -= 1;
            Mul += 1;
            value /= arr.get(depth+1);
        } if(Div > 0){
            value /= arr.get(depth+1);
            Div = Div-1;
            depth += 1;
            dfs(depth,value);
            depth -= 1;
            Div += 1;
            value *= arr.get(depth+1);
        }
    }
}