class LongestUniqueSubString {
    int longestUniqueSubsttr(String S){
        int p1 = 0;
        int p2 = 0;
        int maxLen = 0;
        List<Character> list = new ArrayList<>();
        while(p1<=p2 && p2< S.length()){
            char c = S.charAt(p2);
            if(list.contains(c)) {
                maxLen = Math.max(maxLen, p2-p1);
                while(S.charAt(p1) != c){
                    list.remove(0);
                    p1++;
                }
                list.remove(0);
                p1++;
            }
            list.add(c);
            p2++;
        }
        return Math.max(p2-p1, maxLen);
    }
    
    int longestUniqueSubstrWithHashMap(String S){
        HashMap<Character, Integer> cache = new HashMap<>();
        int maxLen = 0;
        int p1=0, p2=0;
        while(p1<=p2 && p2<S.length()) {
            char c = S.charAt(p2);
            if(cache.containsKey(c)) {
                p1 = Math.max(p1, cache.get(c) + 1);
            }
            cache.put(c, p2);
            p2++;
            maxLen = Math.max(maxLen, p2-p1);
        }
        return maxLen;
    }
}
