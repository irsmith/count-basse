public class BinSearch {


    private static int iterative(int [] a, int lo, int hi, int k) {

        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (a[mid] == k) return mid;
            if (k > a[mid]) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {4,5};
        int res = iterative(a, 0, a.length-1, 55) ;

        System.out.printf("%d%n", res);
    }
}
