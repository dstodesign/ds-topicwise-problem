import java.util.*;

class StringAnagrams {
  public static List<Integer> findStringAnagrams(String str, String pattern) {
    List<Integer> results = new ArrayList<Integer>();
    int p1 = 0, p2 = 0;
    int n = str.length();
    Map<Character, Integer> freqMap = getCharFreqMap(pattern);
    while(p2<n) {
      char ch = str.charAt(p2);
      if(freqMap.get(ch) == null) {
        p1 = p2 + 1;
        freqMap = getCharFreqMap(pattern);
      } else {
        int count = freqMap.get(ch);
        freqMap.put(ch, count-1);
        if(isPatternFound(freqMap)) {
          results.add(p1);
        }
        if(p2 - p1 == pattern.length()-1) {
          freqMap.put(str.charAt(p1), freqMap.get(str.charAt(p1))+1);
          p1++;
        } 
      }
      p2++;
    }
    return results;
  }

  private static Map<Character, Integer> getCharFreqMap(String str) {
    Map<Character, Integer> freqMap = new HashMap<>();
    for(Character c : str.toCharArray()) {
      freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
    }
    return freqMap;
  }

  private static boolean isPatternFound(Map<Character, Integer> freqMap) {
    for(int val : freqMap.values()) {
      if(val != 0) return false;
    }
    return true;
  }
}
