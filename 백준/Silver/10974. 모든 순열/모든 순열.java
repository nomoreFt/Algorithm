import java.io.*;

public class Main{
	static StringBuilder sb;
	static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = i;
        }
        permutation(arr,n);
        System.out.println(sb.toString());
    } 
    public static void permutation(int[] arr, int n){
        int splitNum = n;
        int temp = 0;
        for(int i = 1; i <= n; i++){
            if( i == n) sb.append(arr[i]+"\n");
            else sb.append(arr[i] + " ");
        }
        for(int i = n; i >1; i--){
            if(arr[i-1] < arr[i]) {
                splitNum = i-1;
                break;
               }
        }
        if(splitNum == n) return;
        for(int j = n; j > splitNum; j--){
            if(arr[splitNum] < arr[j]){
                temp = arr[splitNum];
                arr[splitNum] = arr[j];
                arr[j] = temp;
                 break;
            }
        }
        for(int k=splitNum+1; k < n; k++){
            for(int l = k+1; l <= n; l++){
                if(arr[k] > arr[l]){
                    temp = arr[k];
                    arr[k] = arr[l];
                    arr[l] = temp;
                }
            }
        }
        permutation(arr,n);
    }
}