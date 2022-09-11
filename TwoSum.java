import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int [] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (numsMap.get(target - current) != null) {
                result[0] = i;
                result[1] = numsMap.get(target - current);
                break;
            } else {
                numsMap.put(current, i);
            }
        }
        return result;
    }
}