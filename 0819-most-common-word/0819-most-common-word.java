class Solution {
    public String mostCommonWord(String p, String[] banned) {
       Set<String> ban = new HashSet<>(Arrays.asList(banned));
       Map<String,Integer> count = new HashMap<>();

       String[] words = p.replaceAll("\\W+"," ").toLowerCase().split(" "); 

        for(String word : words){
            if(!ban.contains(word)){
                count.put(word,count.getOrDefault(word,0)+1);
            }
        }
        
        return Collections.max(count.entrySet(),Map.Entry.comparingByValue()).getKey();
    }
}