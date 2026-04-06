class Solution {
    public int sumOfUnique(int[] nums) {
        // Since 1 <= nums[i] <= 100
        int[] freq = new int[101];

        // Count frequency of each number
        for (int num : nums) {
            freq[num]++;
        }

        // Sum numbers that appear exactly once
        int sum = 0;
        for (int val = 1; val <= 100; val++) {
            if (freq[val] == 1) {
                sum += val;
            }
        }

        return sum;
    }
}