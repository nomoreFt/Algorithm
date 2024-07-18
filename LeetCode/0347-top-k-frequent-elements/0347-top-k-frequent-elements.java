class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0) + 1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for(int elem : map.keySet()){
            pq.add(new int[]{elem, map.get(elem)});
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = pq.poll()[0];
        }
        return result;
    }
}