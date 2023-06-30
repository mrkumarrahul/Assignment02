import java.util.HashSet;
import java.util.Set;

public class  FindOriginalArray{
    public static int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) {
            // If the length is odd, it cannot be a doubled array
            return new int[0];
        }

        int[] original = new int[n / 2];
        Set<Integer> seen = new HashSet<>();

        for (int num : changed) {
            if (seen.contains(num / 2)) {
                // Skip if we have encountered the same number before
                continue;
            }

            seen.add(num / 2);
        }

        int i = 0;
        for (int num : seen) {
            original[i++] = num;
        }

        return original;
    }

    public static void main(String[] args) {
        int[] changed = {1, 3, 4, 2, 6, 8};
        int[] original = findOriginalArray(changed);

        if (original.length == 0) {
            System.out.println("Empty array");
        } else {
            for (int num : original) {
                System.out.print(num + " ");
            }
        }
    }
}
