package im.dhf.leetcode.p387;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int firstUniqChar(String s) {
        if (null == s || s.length() == 0) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            Character key = Character.valueOf(c);
            int cnt = 0;
            if (map.containsKey(key)) {
                cnt = map.get(key);
            }
            ++cnt;
            map.put(key, cnt);
        }
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            Character key = Character.valueOf(c);
            int cnt = map.get(key);
            if (cnt == 1) {
                return i;
            }
        }
        return -1;
    }
}
