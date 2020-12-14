package BAEKJOON.BruteForce;

public class _10972_test {

	public void getNextPermutation(int[] arr, int n) {
		int splitNum = n;
		int temp = 0;
		
		for(int i = n; i > 1; i--) {
			if(arr[i-1] < arr[i]) {
				splitNum = i-1;
				break;
			}
		}
		
		if(splitNum==n){
			System.out.println("-1");
			return;
		}
		
		for(int j=n; j>splitNum; j--) {
			if(arr[j] > arr[splitNum]) {
				temp = arr[j];
				arr[j] = arr[splitNum];
				arr[splitNum] = temp;
				break;
			}
		}
		
		for(int k = splitNum+1; k < n; k++) {
			for(int l = k+1; l <= n; l++) {
				if(arr[k] > arr[l]) {
					temp = arr[k];
					arr[l] = arr[k];
					arr[k] = temp;
				}
			}
		}
		print(arr);
		return;
	}
	public void print(int[] arr) {
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
