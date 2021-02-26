package codingTest.Sort;


//pivot (기준데아터) 를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 변경해주는 것이다.
//기본은 첫 데이터를 기준
//O(NlogN)
//
//재귀
public class 퀵정렬 {
	public static void main(String[] args) {
		  int n = 10;
	        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

	        quickSort(arr, 0, n - 1);

	        for(int i = 0; i < n; i++) {
	            System.out.print(arr[i] + " ");
	        }
	}
	public static void quickSort(int[] arr, int start, int end) {
		 if (start >= end) return; // 원소가 1개인 경우 종료
	        int pivot = start; // 피벗은 첫 번째 원소
	        int left = start + 1;
	        int right = end;

		while(left<=right) {
			 // 피벗보다 큰 데이터를 찾을 때까지 반복
            while (left <= end && arr[left] <= arr[pivot]) left++;
            // 피벗보다 작은 데이터를 찾을 때까지 반복
            while (right >= start+1 && arr[right] >= arr[pivot]) right--;
            if (left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
		}
		   quickSort(arr, start, right - 1);
	        quickSort(arr, right + 1, end);
	}

}
