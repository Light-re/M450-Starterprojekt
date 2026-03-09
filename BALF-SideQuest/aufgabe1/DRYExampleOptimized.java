public class DRYExampleOptimized {
    public static void main(String[] args) {
        // Flattened array: Removes the overhead of sub-array objects
        int[] data = {1, 2, 3, 4, 5, 6};
        
        // StringBuilder: Buffers all text to memory first. 
        // Calling System.out ONCE is orders of magnitude faster than calling it in a loop.
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.length; i += 2) {
            int a = data[i];
            int b = data[i + 1];
            int sum = a + b; // Inlined the addition logic
            
            sb.append(a).append(" + ").append(b).append(" = ").append(sum).append('\n');
        }
        
        System.out.print(sb);
    }
}