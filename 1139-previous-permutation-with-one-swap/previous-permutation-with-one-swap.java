class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        
        // 1. Find first index i from the right such that arr[i] > arr[i + 1]
        int i = n - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }
        
        // If no such index, it's already the smallest permutation
        if (i < 0) {
            return arr;
        }
        
        // 2. Find the largest element to the right of i that is smaller than arr[i]
        int j = n - 1;
        int candidateIndex = -1;
        
        for (int k = n - 1; k > i; k--) {
            if (arr[k] < arr[i]) {
                // First element from the right that is smaller than arr[i]
                if (candidateIndex == -1 || arr[k] > arr[candidateIndex]) {
                    candidateIndex = k;
                } else if (arr[k] == arr[candidateIndex]) {
                    // For duplicates, choose the leftmost occurrence
                    candidateIndex = k;
                }
            }
        }
        
        // 3. Swap arr[i] with arr[candidateIndex]
        int temp = arr[i];
        arr[i] = arr[candidateIndex];
        arr[candidateIndex] = temp;
        
        return arr;
    }
}