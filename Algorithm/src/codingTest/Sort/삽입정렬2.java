package codingTest.Sort;

public class ��������2 {
	public static void main(String[] args) {
		int n = 10;
		int[] arr = {7,5,9,0,3,1,6,2,4,8};
	//�ι�° ���Һ��� �����ؼ� ����������
		//�����ؼ� ��ĭ�� �������鼭 �Ѵ�
		
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
