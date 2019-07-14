public class AppleStock {

    public static void main(String[] args) {
        final int [] a = { 5,10,4,6,12 };

        System.out.printf("profit: %d %n", becomeABillionaire(a));

        //System.out.printf("profit: %d %n", f(a));

    }
    static int buy = 0, sell = 0;
//https://stackoverflow.com/questions/7086464/maximum-single-sell-profit
    static int becomeABillionaire(int arr[]) {
        int i = 0,  min = 0, profit = 0;

        for (i = 0; i < arr.length; i++) {
            if (arr[i] < arr[min])
                min = i;
            else if (arr[i] - arr[min] > profit) {
                buy = min;
                sell = i;
                profit = arr[i] - arr[min];
            }

        }
        System.out.println("We will buy at : " + arr[buy] + " sell at " + arr[sell] +
                " and become billionaires worth " + profit );
        return profit;
    }


    private static int f(int[] a) {
        if (a.length <2 ) return 0;

        int gmaxProfit = 0;
        int gmin = a[0];
        for (int i=1;i<a.length;i++) {
            int localProfit = a[i] - gmin;
            if (localProfit > gmaxProfit) {
                gmaxProfit = localProfit;
            }
            if (a[i] < gmin ){
                gmin = a[i];
            }


        }

        return gmaxProfit;

    }
}
