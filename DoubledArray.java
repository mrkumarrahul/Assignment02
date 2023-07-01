import java.util.Arrays;
import java.util.HashSet;

public class DoubledArray {
    public static int[] findOriginalArray(int[] changed) {
        int n = changed.length;

        if (n % 2 != 0) {
            return new int[0];
        }

        Arrays.sort(changed);

        int[] original = new int[n / 2];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int half = changed[i] / 2;

            if (set.contains(half)) {
                set.remove(half);
            } else {
                original[i / 2] = half;
                set.add(changed[i]);
            }
        }

        if (set.isEmpty()) {
            return original;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        int[] changed = {1, 3, 4, 2, 6, 8};
        int[] result = findOriginalArray(changed);
        System.out.println(Arrays.toString(result));
    }
}
