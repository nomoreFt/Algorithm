class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int index = 2; // 초기값은 2, 세 번째 원소부터 확인 시작

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) { // 현재 원소가 index-2 원소와 다르면
                nums[index] = nums[i]; // 현재 원소를 index 위치에 저장
                index++;
            }
        }

        return index; // 중복을 제거한 후의 길이 반환
    }
}
