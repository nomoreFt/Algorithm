class Solution {
        public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || k < 1) {
            throw new IllegalArgumentException("Invalid input");
        }

        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<String> set = new HashSet<>();
        
        // 초기 힙과 집합 설정
        minHeap.offer(new int[]{matrix[0][0], 0, 0});
        set.add("0,0");
        
        while (k > 1) {
            int[] top = minHeap.poll();
            int row = top[1];
            int col = top[2];

            if (col + 1 < n && !set.contains(row + "," + (col + 1))) {
                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
                set.add(row + "," + (col + 1));
            }

            if (row + 1 < n && !set.contains((row + 1) + "," + col)) {
                minHeap.offer(new int[]{matrix[row + 1][col], row + 1, col});
                set.add((row + 1) + "," + col);
            }

            k--;
        }

        return minHeap.peek()[0];
    }
}