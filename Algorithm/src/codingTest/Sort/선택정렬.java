package codingTest.Sort;

public class �������� {
//ó������ ���� ������ �߿��� ���� ���� �����͸� ������ �� �տ� �ִ� �����Ϳ� �ٲٴ� ���� �ݺ�
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
