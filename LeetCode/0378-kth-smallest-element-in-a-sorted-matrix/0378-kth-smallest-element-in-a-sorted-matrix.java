class Solution {
        public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // 첫 열의 모든 원소를 힙에 추가
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }
        
        int count = 0;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int value = curr[0];
            int row = curr[1];
            int col = curr[2];
            
            if (++count == k) {
                return value;
            }
            
            if (col + 1 < n) {
                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }
        
        throw new IllegalArgumentException("Invalid input.");
    }

}