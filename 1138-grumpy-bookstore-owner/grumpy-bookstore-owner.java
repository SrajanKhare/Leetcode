class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        
        // 1. Customers already satisfied without any technique
        int baseSatisfied = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                baseSatisfied += customers[i];
            }
        }
        
        // 2. Sliding window to find max extra satisfied customers
        int extraSatisfied = 0;
        int maxExtraSatisfied = 0;
        
        // Initial window [0 .. minutes-1]
        for (int i = 0; i < minutes && i < n; i++) {
            if (grumpy[i] == 1) {
                extraSatisfied += customers[i];
            }
        }
        maxExtraSatisfied = extraSatisfied;
        
        // Slide the window from [1 .. minutes] to [n-minutes .. n-1]
        for (int i = minutes; i < n; i++) {
            // Add new element (right end) if owner is grumpy there
            if (grumpy[i] == 1) {
                extraSatisfied += customers[i];
            }
            // Remove element going out of window (left end)
            int left = i - minutes;
            if (grumpy[left] == 1) {
                extraSatisfied -= customers[left];
            }
            // Update max
            if (extraSatisfied > maxExtraSatisfied) {
                maxExtraSatisfied = extraSatisfied;
            }
        }
        
        // 3. Total satisfied = always satisfied + max extra from technique
        return baseSatisfied + maxExtraSatisfied;
    }
}