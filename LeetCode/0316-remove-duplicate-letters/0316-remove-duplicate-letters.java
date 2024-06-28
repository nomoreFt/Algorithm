class Solution {
    public Set<Character> toSortedSet(String s) {
        Set<Character> set = new TreeSet<>((o1, o2) -> {
            if (o1.equals(o2)) {
                return 0;
            } else if (o1 > o2) {
                return 1;
            } else {
                return -1;
            }
        });
        
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set;
    }
    public String removeDuplicateLetters(String s) {
        if (s.isEmpty()) {
            return "";
        }

        for(char c : toSortedSet(s)){
            String suffix = s.substring(s.indexOf(c));
            if(toSortedSet(s).equals(toSortedSet(suffix))){
                return c + removeDuplicateLetters(suffix.replace(String.valueOf(c),""));
            }
        }

        return "";
    }
}