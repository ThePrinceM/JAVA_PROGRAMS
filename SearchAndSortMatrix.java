public class SearchMatrix {
    private int[][] matrix;

    // Constructor
    public SearchMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    // Method to search for an element in the matrix
    public boolean searchMe(int target) {
        // Check if the matrix is initialized
        if (matrix == null) {
            System.out.println("Matrix not initialized.");
            return false;
        }

        // Search through the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    System.out.println("Element found at location: [" + i + "," + j + "]");
                    return true;
                }
            }
        }
        System.out.println("Element not found in the matrix.");
        return false;
    }

    // Method to reorder the matrix (sort each row)
    public void reorder() {
        // Check if the matrix is initialized
        if (matrix == null) {
            System.out.println("Matrix not initialized.");
            return;
        }

        // Sort each row of the matrix
        for (int i = 0; i < matrix.length; i++) {
            java.util.Arrays.sort(matrix[i]);
        }
    }

    // Method to print the matrix
    public void printMatrix() {
        // Check if the matrix is initialized
        if (matrix == null) {
            System.out.println("Matrix not initialized.");
            return;
        }

        // Print each element in the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // New line after each row
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        int[][] matrix = {
            {3, 5, 1},
            {2, 8, 7},
            {4, 6, 9}
        };

        // Create an instance of SearchMatrix
        SearchMatrix sm = new SearchMatrix(matrix);
        
        // Search for a specific element
        sm.searchMe(8);  // Example search
        sm.reorder();     // Reorder the matrix (sort each row)

        // Print the reordered matrix
        System.out.println("Reordered matrix:");
        sm.printMatrix();
    }
}

