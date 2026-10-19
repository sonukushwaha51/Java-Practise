package combinations;

public class StockSell {

    public static void main(String[] args) {

        int[] nums = {1,14,43,12,5,12,4,24,13,67};

        int minPrice = Integer.MAX_VALUE;
        int sellPrice = 0;
        int sellingDay = 0;
        int buyingDay = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minPrice) {
                minPrice = nums[i];
                buyingDay = i+1;
            } else if (nums[i] - minPrice > sellPrice) {
                sellPrice = nums[i];
                sellingDay = i+1;
            }
        }
        System.out.println(buyingDay);
        System.out.println(sellingDay);
        System.out.println(sellPrice);
        System.out.println(minPrice);
    }
}
