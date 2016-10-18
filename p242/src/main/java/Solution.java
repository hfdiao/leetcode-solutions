import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (null == s || null == t || s.length() != t.length()) {
            return false;
        }
        if (s == t) {
            return true;
        }

        Map<Character, Integer> sCharCntMap= new HashMap<>();
        for (char c : s.toCharArray()) {
            Character key = Character.valueOf(c);
            int cnt = 0;
            if (sCharCntMap.containsKey(key)) {
                cnt = sCharCntMap.get(key);
            }
            ++cnt;
            sCharCntMap.put(key, cnt);
        }

        Map<Character, Integer> tCharCntMap= new HashMap<>();
        for (char c : t.toCharArray()) {
            Character key = Character.valueOf(c);
            if (!sCharCntMap.containsKey(key)) {
                return false;
            }
            int sCnt = sCharCntMap.get(key);

            int tCnt = 0;
            if (tCharCntMap.containsKey(key)) {
                tCnt = tCharCntMap.get(key);
            }
            if (tCnt >= sCnt) {
                return false;
            }
            ++tCnt;
            tCharCntMap.put(key, tCnt);
        }
        return true;
    }
}
