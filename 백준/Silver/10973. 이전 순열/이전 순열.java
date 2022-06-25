import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n+1];
		String[] str = br.readLine().split(" ");
		for(int i = 1 ; i <= n ; i++) {
			arr[i] = Integer.parseInt(str[i-1]);
		}
		getPostPermutation(arr, n);
	}
	public static void getPostPermutation(int[] arr, int n) {
		int splitNum = n;
		int temp = 0;
		for(int i = n; i > 1 ; i--) {
			if(arr[i-1] > arr[i]) {
				splitNum = i-1;
				break;
			}
		}
		if(splitNum == n) {
			System.out.println("-1");
			return;
		}
		for(int j = n; j > splitNum; j--) {
			if(arr[splitNum] > arr[j]) {
				temp = arr[splitNum];
				arr[splitNum] = arr[j];
				arr[j] = temp;
				break;
			}
		}
		for(int j = splitNum+1; j < n; j++) {
			for(int k = j+1; k <= n; k++) {
				if(arr[j] < arr[k]) {
					temp = arr[j];
					arr[j] = arr[k];
					arr[k] = temp;
				}
			}
		}
		print(arr, n);
		
	}
	public static void print(int[] arr, int n) {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			if(i == n) {
				sb.append(arr[i]);
			}
			else {
				sb.append(arr[i] + " ");
			}
		}
		System.out.print(sb.toString());
	}
}