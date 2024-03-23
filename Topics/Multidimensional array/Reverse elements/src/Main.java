class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {
       for (int[] row : twoDimArray) {
            int start = 0;
            int end = row.length - 1;
            while (start < end) {
                int temp = row[start];
                row[start] = row[end];
                row[end] = temp;
                start++;
                end--;
            }
        }

    }
}
