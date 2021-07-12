package codingTest.Sort;


//pivot (���ص�����) �� �����ϰ� �� ���غ��� ū �����Ϳ� ���� �������� ��ġ�� �������ִ� ���̴�.
//�⺻�� ù �����͸� ����
//O(NlogN)
////
//���
public class ������ {
	public static void main(String[] args) {

		int[] arr = {5,7, 9, 0, 3, 1, 6, 2, 4, 8};
		int n = 10;
		
		quickSort(arr, 0, n - 1);
		
		for(int i = 0 ; i < n; i++) {
			System.out.println(arr[i] + " ");
		}
	}
	public static void quickSort(int[] arr, int start, int end) {
		//��� ���� ���ǰ����� 1�̸� return
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
		//left,right ����
		
		//�����Ǳ� ������ left -> ū �� ã��
		//right <- ���� �� ã��
		//�����Ǹ� pivot�� right ���� ������ ��ȯ
		//�ȵǸ� right, left �� swap
		
		//���� pivot�� �������� quickSort �����
	}

}
