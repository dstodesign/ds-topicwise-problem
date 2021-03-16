class MaxSubstringAfterKMostChanges
{
    public int characterReplacement(String s, int k)
    {
        int K = k;
        int p1 = 0, p2 = 0;
        int n = s.length();
        int index = 0, maxLen = 0;
        while(index<n) {
            if(p2<s.length() && s.charAt(p2) == s.charAt(index))
                p2++;
            else if(p2<s.length() && k > 0) {
                k--;
                p2++;
            } else {
                while(k > 0 && p1>0) {
                    k--;
                    p1--;
                } 
                maxLen = Math.max(maxLen, p2-p1);
                char c = s.charAt(index);
                k = K;
                while(index< n && s.charAt(index) == c) {
                    index++;
                }
                p1 = index;
                p2 = p1;
            }
        }
        while(k > 0 && p1>0) {
            k--;
            p1--;
        }
        return Math.max(maxLen, p2-p1);
    }

    public int characterReplacementWithHashMap(String s, int k) {
	      int p1 = 0, p2 = 0;
        int n = s.length();
        int maxLen = 0;
        int maxRepeatingChar = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        while(p2<n) {
            char c = s.charAt(p2);
            p2++;
            int count = freqMap.getOrDefault(c, 0) + 1;
            freqMap.put(c, count);
            maxRepeatingChar = Math.max(maxRepeatingChar, count);
            if(p2 - p1 - maxRepeatingChar > k) {
                char ch = s.charAt(p1);
                freqMap.put(ch, freqMap.get(ch) - 1);
                p1++;
            }
            maxLen = Math.max(maxLen, p2 - p1);
        }
        return maxLen;
    }
}
