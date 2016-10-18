package im.dhf.leetcode.p389;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public char findTheDifference(String s, String t) {
        Objects.requireNonNull(s, "s is null");
        Objects.requireNonNull(t, "t is null");
        if (t.length() - s.length() != 1) {
            throw new IllegalArgumentException("length of t is not match");
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            Character key = Character.valueOf(c);
            int cnt = 0;
            if (map.containsKey(key)) {
                cnt = map.get(key);
            }
            ++cnt;
            map.put(key, cnt);
        }
        for (char c : t.toCharArray()) {
            Character key = Character.valueOf(c);
            if (!map.containsKey(key)) {
                return c;
            }

            int cnt = map.get(key);
            --cnt;
            if (cnt <= 0) {
                map.remove(key);
            } else {
                map.put(key, cnt);
            }
        }
        throw new IllegalStateException("make the compiler happy");
    }
}
