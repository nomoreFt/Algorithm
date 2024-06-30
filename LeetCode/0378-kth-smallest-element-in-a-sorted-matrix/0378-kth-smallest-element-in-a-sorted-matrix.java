class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] answer = new int[n * n];
        
        int answerIdx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer[answerIdx++] = matrix[i][j];
            }
        }
        
        Arrays.sort(answer);
        return answer[k - 1];
    }
}