package codingTest.Sort;

public class 선택정렬 {
//처리되지 않은 데이터 중에서 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸는 것을 반복
	public static void main(String[] args) {
		int n = 10;
		int[] arr = {7,5,9,0,3,1,6,2,4,8};
		
		for(int i = 0 ; i < n ; i++) {
			int min_index = i;
			for(int j = i+1; j < n; j++) {
				if( arr[min_index] > arr[j]) {
					min_index = j;
				}
			}
			int temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;
		}
		
		for(int s : arr) {
			System.out.print(s+",");
		}
	}

}
