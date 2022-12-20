import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] arr = new int[n+1];
		for(int i = 0; i < str.length; i++) {
			arr[i+1] = Integer.parseInt(str[i]);
		}
		getNextPermutation(arr,n);
	}


	public static void getNextPermutation(int[] arr, int n) {
		int splitNum = n;
		int temp = 0;
		
		// 바뀌어야 할 부분 찾는 for문
		for(int i=n; i>1; i--) {
			if(arr[i-1] < arr[i]) {
				splitNum = i-1;
				break;
			}
		}
		
		//splitNum이 바뀌지 않았으며 맨 마지막이므로 -1 출력
		if(splitNum == n) {
			System.out.println("-1");
			return;
		}
		
		// 위치를 바꾸는 for문
		for(int j=n; j>splitNum; j--) {
			if(arr[j] > arr[splitNum]) {
				temp = arr[splitNum];
				arr[splitNum] = arr[j];
				arr[j] = temp;
				break;
			}
		}
		
		// 뒷부분 정렬 하는 부분
		for(int k=splitNum+1; k<n; k++) {
			for(int l=k+1; l<=n; l++) {
				if(arr[k] > arr[l]) {
					temp = arr[l];
					arr[l] = arr[k];
					arr[k] = temp;
				}
			}
		}
		
		print(arr);
		return;
		
	}
	public static void print(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < arr.length; i++) {
			if(i == arr.length-1)
				sb.append(arr[i]);
			else {
				sb.append(arr[i]);
				sb.append(" ");
			}
		}
		System.out.println(sb.toString());
	}
}
