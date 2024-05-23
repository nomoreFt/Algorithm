class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int index = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }

        // 새 배열로 잘라내기
        int[] reuslt = Arrays.copyOfRange(nums, 0, index);
        return reuslt.length;
    }

}
