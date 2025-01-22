public class profitloss{
   public static void main(String[] args){
   double cost_price = 129;
   int sell_price = 191;
   double profit = (sell_price - cost_price);
   double profit_percentage = (profit/cost_price)*100;
   System.out.println("The Cost Price is INR " + cost_price + " and Selling Price is INR " + sell_price + ". The Profit is INR "+ profit +" and the Profit Percentage is "+ profit_percentage);
 }
}
