class Solution {
        public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int count = 1; // 현재 원소의 개수
        int length = 1; // 최종 결과 배열의 길이, 첫 원소는 포함됨

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++; // 현재 원소가 이전 원소와 같으면 개수 증가
            } else {
                count = 1; // 현재 원소가 이전 원소와 다르면 개수 초기화
            }

            if (count <= 2) { // 현재 원소의 개수가 2 이하이면 길이 증가
                nums[length] = nums[i]; // 배열 수정 (결과 배열의 길이를 유지하기 위함)
                length++;
            }
        }

        return length; // 중복을 제거한 후의 길이 반환
    }

}
