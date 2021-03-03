package codingTest.Sort;

//특정 조건이 부합할때만 사용하는데 매우 빠르게 동작
//데이터의 크기 범위가 제한되어 정수 형태로 표현할 수 있을 떄 사용 가능

//min, max개수로 배열을 생성하고 cnt를 세어 해당 데이터가 몇번이나 들어왔는지 체크
//동일한 값을 가진 데이터가 여러 개 등장할 때 효과적으로 사용
public class 계수정렬 {
	public static final int MAX_VALUE = 9;

	public static void main(String[] args) {
		int n = 15;
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
		
		int[] cnt = new int[MAX_VALUE +1];
		
		for(int i = 0; i < n; i++){
			cnt[arr[i]] += 1;
		}
		for(int i = 0; i < MAX_VALUE; i++) {
			for(int j = 0; j < cnt[i]; j++) {
				System.out.println(i + " ");
			}
		}
	}
}
