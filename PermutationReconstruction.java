import java.util.ArrayList;
import java.util.List;

public class PermutationReconstruction {
    public static int[] findPermutation(String s) {
        int n = s.length();
        List<Integer> perm = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            perm.add(i);
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                perm.add(perm.remove(0));
            } else {
                perm.add(0, perm.remove(perm.size() - 1));
            }
        }

        int[] result = new int[perm.size()];
        for (int i = 0; i < perm.size(); i++) {
            result[i] = perm.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "IDID";
        int[] result = findPermutation(s);
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
