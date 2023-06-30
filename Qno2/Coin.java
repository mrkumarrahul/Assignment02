public class Coin {
    public static int arrangeCoins(int n) {
        int completeRows = 0;
        int remainingCoins = n;
        int currentRow = 1;

        while (remainingCoins >= currentRow) {
            remainingCoins -= currentRow;
            completeRows++;
            currentRow++;
        }

        return completeRows;
    }

    public static void main(String[] args) {
        int n = 5;
        int result = arrangeCoins(n);
        System.out.println(result);
    }
}
