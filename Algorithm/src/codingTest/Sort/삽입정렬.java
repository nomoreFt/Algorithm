package codingTest.Sort;

//ó������ ���� �����͸� �ϳ��� ��� ������ ��ġ�� �����մϴ�.

//������ �����Ͱ� ���ĵǾ��ִٰ� �����ϰ� �� �ںκ��� ��� ��ġ�� ���� ����ϴ� ��.
public class �������� {
public static void main(String[] args) {
	int n = 10;
	int[] arr = {7,5,9,0,3,1,6,2,4,8};
	
	//1���� �����ؼ� ������ ���µ� j�� i ���ʰ͵� ��� ���ϸ� ���ư�����. �̹� ���� ���ĵǾ��ٰ� �����ϱ⶧���� arr[j] < arr[j-1]�� �� ũ�� swap, �ƴѰ� ������ break;
	//O(N����) ���ĵǾ��� ���¶�� �ſ� ������ ���۵�.
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
