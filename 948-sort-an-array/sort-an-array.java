class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        // Find min and max to know the value range
        int min = nums[0], max = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }

        int range = max - min + 1;              // total distinct values
        int[] count = new int[range];

        // Count frequencies
        for (int x : nums) {
            count[x - min]++;
        }

        // Overwrite nums in sorted order
        int idx = 0;
        for (int v = 0; v < range; v++) {
            while (count[v] > 0) {
                nums[idx++] = v + min;
                count[v]--;
            }
        }

        return nums;
    }
}