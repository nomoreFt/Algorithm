package codingTest.Sort;

public class 삽입정렬2 {
	public static void main(String[] args) {
		int n = 10;
		int[] arr = {7,5,9,0,3,1,6,2,4,8};
	//두번째 원소부터 시작해서 마지막까지
		//지정해서 한칸씩 내려오면서 한다
		
		for(int i = 1; i < n; i++) {
			for(int j = i; j > 0; j--) {
				if(arr[j] < arr[j-1]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
				else break; 
			}
		}
	}
}
