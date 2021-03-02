package codingTest.Sort;

public class �����Ŀ���2 {
	public static void main(String[] args) {
		int[] arr = {5,7, 9, 0, 3, 1, 6, 2, 4, 8};
		int n = 10;
		
		quickSort(arr, 0, n - 1);
		
		for(int i = 0 ; i < n; i++) {
			System.out.println(arr[i] + " ");
		}
	}
	public static void quickSort(int[] arr, int start, int end) {
		//�ǳʸ� return
		if(start>=end) return;
		int pivot = start;
		int left = start+1;
		int right = end;
		
		while(left <= right) {
			//���� -> ������ ���鼭 ū�� Ȯ��
			while(left <= end && arr[left] <= arr[pivot]) left++;
			while(right >= start+1 && arr[right] >= arr[pivot]) right--;
			
			if(left > right) {
				swap(arr,right,pivot);
			}else {
				swap(arr,left,right);
			}
		}
		quickSort(arr,start,right-1);
		quickSort(arr,right+1,end);
		
	}
	public static void swap (int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
