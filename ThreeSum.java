import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int leftIndex = i+1;
            int rightIndex = nums.length - 1;

            // if we have already come across this number for "a"
            if (i > 0 && current == nums[i-1]) {
                continue;
            }

            while (leftIndex < rightIndex) {
                int leftNumber = nums[leftIndex];
                int rightNumber = nums[rightIndex];
                int sum = current + leftNumber + rightNumber;
                if (sum > 0) {
                    rightIndex--;
                } else if (sum < 0) {
                    leftIndex++;
                } else {
                    result.add(Arrays.asList(current, leftNumber, rightNumber));
                    leftIndex++;
                    while (nums[leftIndex] == nums[leftIndex-1] && leftIndex < rightIndex) {
                        leftIndex++;
                    }
                }
            }
        }
        return result;
    }
}
// nums = [-1,0,1,2,-1,-4]
// nums = [-4,-1,-1,0,1,2]
// sort the array
// we have a and then two pointers acting as "b" and "c"
// move right pointer if the sum is larger than 0
// move left pointer is sum is smaller than 0
// if it is equal to 0, add it to result and increment
// left pointer until there we reach a unique b
// time complexity: O(N^2)
// space complexity: O(1) sorting is done in place
