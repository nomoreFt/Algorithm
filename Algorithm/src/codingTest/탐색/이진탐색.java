package codingTest.Å½»ö;

public class ÀÌÁøÅ½»ö {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int binarySearch(int[] arr, int target, int start, int end) {
		while(start <= end) {
			int mid = (start + end) / 2;
			if(arr[mid] == target) return mid;
			else if (arr[mid] > target) end = mid - 1;
			else start = mid + 1;
		}
		return -1;
	}
}
