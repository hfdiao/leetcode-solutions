package im.dhf.leetcode.p387;

import java.util.*;

public class Solution {
    public int firstUniqChar(String s) {
        if (null == s || s.length() == 0) {
            return -1;
        }

        Set<Character> appearances = new HashSet<>();
        LinkedHashMap<Character, Integer> candidateIndexes = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            Character key = Character.valueOf(c);
            if (appearances.contains(key)) {
                candidateIndexes.remove(key);
            } else {
                appearances.add(key);
                candidateIndexes.put(key, i);
            }
        }
        if (candidateIndexes.isEmpty()) {
            return -1;
        } else {
            for (Map.Entry<Character, Integer> entry : candidateIndexes.entrySet()) {
                return entry.getValue();
            }
        }
        return -1;
    }
}
