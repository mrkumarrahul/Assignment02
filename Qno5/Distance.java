public class Distance {
    public static int distanceValue(int[] arr1, int[] arr2, int d) {
        int distance = 0;

        for (int num1 : arr1) {
            boolean hasCloseElement = false;

            for (int num2 : arr2) {
                if (Math.abs(num1 - num2) <= d) {
                    hasCloseElement = true;
                    break;
                }
            }

            if (!hasCloseElement) {
                distance++;
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 8};
        int[] arr2 = {10, 9, 1, 8};
        int d = 2;
        int result = distanceValue(arr1, arr2, d);
        System.out.println(result);
    }
}
