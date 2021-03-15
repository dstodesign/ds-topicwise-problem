class SmallestSubarrayWithGivenSum {
    
    // n is array length
    // x is the target sum
    public static long sb(long a[], long n, long x) {
        long len = Long.MAX_VALUE;
        int p1 = 0;
        int p2 = 0;
        long sum = 0l;
        while(p1<=p2 && p2<n) {
            sum = sum + a[p2];
            p2++;
            while(sum >= x) {
                len = len > (p2-p1) ? (p2-p1) : len;
                sum = sum - a[p1];
                p1++;
            }
        }
        return len == Long.MAX_VALUE ? -1 : len;
    }
}
