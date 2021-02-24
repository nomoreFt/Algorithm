package codingTest.Sort;

//처리되지 않은 데이터를 하나씩 골라 적절한 위치에 삽입합니다.

//앞쪽의 데이터가 정렬되어있다고 생각하고 그 뒤부분이 어느 위치로 갈지 고민하는 것.
public class 삽입정렬 {
public static void main(String[] args) {
	int n = 10;
	int[] arr = {7,5,9,0,3,1,6,2,4,8};
	
	//1부터 시작해서 끝가지 가는데 j는 i 왼쪽것들 모두 비교하며 나아가야함. 이미 앞은 정렬되었다고 생각하기때문에 arr[j] < arr[j-1]이 더 크면 swap, 아닌것 만나면 break;
	//O(N제곱) 정렬되어진 상태라면 매우 빠르게 제작됨.
	for(int i = 1 ; i < n; i++) {
		for(int j = i; j > 0; j--) {
			if(arr[j] < arr[j-1]) {
				int temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
			}
			else break;
		}
	}
	for(int b : arr) {
		System.out.println(b);
}
}
}
