class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //빈도를 맵으로 저장
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int n : nums){
            frequencyMap.put(n, frequencyMap.getOrDefault(n,0) + 1);
        }
        //저장된 맵을 PriorityQueue로 정렬 (빈도에 따라 key값으로 정렬)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for(int key : frequencyMap.keySet()){
            pq.add(new int[]{key, frequencyMap.get(key)});
        }

        int[] result = new int[k];
        for(int i =  0; i < k; i++){
            result[i] = pq.poll()[0];
        }
        
        return result;
    
    }
}