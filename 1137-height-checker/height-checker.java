import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        // Make a copy of the original array
        int[] expected = heights.clone();
        
        // Sort the copy to get the expected order
        Arrays.sort(expected);
        
        // Count indices where heights[i] != expected[i]
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        
        return count;
    }
}