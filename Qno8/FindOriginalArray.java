import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindOriginalArray {
    public static int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) {
            // If the length is odd, it cannot be a doubled array
            return new int[0];
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> original = new ArrayList<>();

        for (int num : changed) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int num : changed) {
            if (countMap.getOrDefault(num, 0) == 0) {
                // Skip if the number is already used
                continue;
            }

            int doubleNum = num * 2;
            if (countMap.getOrDefault(doubleNum, 0) == 0) {
                // If the double value doesn't exist, it is not a doubled array
                return new int[0];
            }

            original.add(num);
            countMap.put(num, countMap.getOrDefault(num, 0) - 1);
            countMap.put(doubleNum, countMap.getOrDefault(doubleNum, 0) - 1);
        }

        int[] result = new int[original.size()];
        for (int i = 0; i < original.size(); i++) {
            result[i] = original.get(i);
        }

        return result;
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
