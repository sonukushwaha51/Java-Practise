package complexity;

public class StockSell {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        int highest = 0;
        int minPrice = Integer.MAX_VALUE;
        int sellingDay = 0;
        int buyingDay = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                buyingDay = i + 1;
            } else if (prices[i] - minPrice > highest) {
                highest = prices[i] - minPrice;
                sellingDay = i + 1;
            }
        }
        System.out.println(highest);
        System.out.println("Bought on day "+ buyingDay + " and sold on day "+ sellingDay);
    }
}
