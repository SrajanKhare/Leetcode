class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        // Base case: first row is always [1]
        if (numRows == 0) {
            return triangle;
        }
        
        // Add first row
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        
        // Generate remaining rows
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();
            
            // First element is always 1
            currentRow.add(1);
            
            // Calculate middle elements
            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
            // Last element is always 1
            currentRow.add(1);
            
            triangle.add(currentRow);
        }
        
        return triangle;
    }
}
