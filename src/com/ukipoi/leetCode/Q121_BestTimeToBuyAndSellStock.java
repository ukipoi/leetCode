package com.ukipoi.leetCode;

public class Q121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int i = maxProfit(prices);
        System.out.println(i);
    }

    public static int maxProfit(int[] prices) {
        if (prices.length==0){
            return 0;
        }
        int length = prices.length;
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < length; i++) {
            if (prices[i]>minPrice){
                int temp = prices[i]-minPrice;
                if (temp>profit){
                    profit=temp;
                }
            }else {
                minPrice=prices[i];
            }
        }
        return profit;
    }
}
