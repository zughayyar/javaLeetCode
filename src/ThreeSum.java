import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSumOptimized(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // Crucial step!

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 1. Use a Set to store triplets to automatically handle duplicates
        Set<List<Integer>> output = new HashSet<>();

        // 2. Sorting is necessary even in brute force so that
        // [0, 1, -1] and [-1, 0, 1] are seen as the same triplet by the Set
        Arrays.sort(nums);

        int n = nums.length;

        // 3. Adjust loops: j starts after i, k starts after j
        // This replaces your "i != j && i != k..." check and is much cleaner
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Java uses '==' for comparison, not '==='
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // We store the values (nums[i]), not the indices (i)
                        output.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        // Convert the Set back to a List for the return type
        return new ArrayList<>(output);
    }
}
