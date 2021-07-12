package codingTest.Sort;


//pivot (기준데아터) 를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 변경해주는 것이다.
//기본은 첫 데이터를 기준
//O(NlogN)
////
//재귀
public class 퀵정렬 {
	public static void main(String[] args) {

		int[] arr = {5,7, 9, 0, 3, 1, 6, 2, 4, 8};
		int n = 10;
		
		quickSort(arr, 0, n - 1);
		
		for(int i = 0 ; i < n; i++) {
			System.out.println(arr[i] + " ");
		}
	}
	public static void quickSort(int[] arr, int start, int end) {
		//재귀 종료 조건개수가 1이면 return
		if(start>=end) return;
		int pivot = start;
		int left = start+1;
		int right = end;
		
		while(left<=right) {
			while(left<=end&&arr[left]<=arr[pivot]) left++;
			while(right>=start+1&&arr[right]>=arr[pivot]) right--;
			if(left<=right) {
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
			}else {
				int temp = arr[pivot];
				arr[pivot] = arr[right];
				arr[right] = temp;
			}
		}
		quickSort(arr, start, right-1);
		quickSort(arr, right+1, end);
		//left,right 선정
		
		//교차되기 전까지 left -> 큰 값 찾기
		//right <- 작은 값 찾기
		//교차되면 pivot을 right 작은 값으로 변환
		//안되면 right, left 값 swap
		
		//이후 pivot을 기준으로 quickSort 재실행
	}

}
