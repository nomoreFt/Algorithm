import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int val = Integer.parseInt(br.readLine());
		int[] arr = new int[11];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for(int i = 0; i < val ; i++) {
			int a = Integer.parseInt(br.readLine());
			for(int j = 4; j<=a; j++) {
				if((arr[j]) != 0) continue;
				arr[j] = arr[j-1]+arr[j-2]+arr[j-3];
			}
			sb.append(arr[a]+"\n");
		}
		System.out.println(sb.toString());
	}
}
