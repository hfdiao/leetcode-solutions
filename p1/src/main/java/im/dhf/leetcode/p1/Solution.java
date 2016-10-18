package im.dhf.leetcode.p1;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            throw new IllegalArgumentException("nums");
        }

        // key: num, value: indexes of nums that value equals to num
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            int adder = target - num;

            List<Integer> adderIndexes = map.get(adder);
            if (null != adderIndexes) {
                return new int[] {adderIndexes.get(0), i};
            }

            List<Integer> indexes = map.get(num);
            if (null == indexes) {
                indexes = new LinkedList<>();
                map.put(num, indexes);
            }
            indexes.add(i);
        }
        throw new IllegalArgumentException("nums/target");
    }
}
