class Solution {
    public void sortColors(int[] nums) {
        int low = 0; // 0의 위치
        int high = nums.length - 1; // 2의 위치
        int current = 0; // 현재 탐색 중인 위치

        while (current <= high) {
            if (nums[current] == 0) {
                // 현재 값이 0이면 low 위치로 보냄
                swap(nums, low, current);
                low++;
                current++;
            } else if (nums[current] == 2) {
                // 현재 값이 2이면 high 위치로 보냄
                swap(nums, current, high);
                high--;
            } else {
                // 현재 값이 1이면 그냥 다음으로 이동
                current++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}