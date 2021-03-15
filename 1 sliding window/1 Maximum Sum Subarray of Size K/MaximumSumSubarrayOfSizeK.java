class MaximumSumSubarrayOfSizeK{
    // K is size of subarray
    // N is size of array
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        int p1 = 0;
        int p2 = 0;
        int maxSum = 0;
        int sum = 0;
        while(p1<=p2 && p2<N) {
            sum = Arr.get(p2) + sum;
            p2++;
            if(p2-p1 == K) {
                maxSum = Math.max(sum, maxSum);
                sum = sum - Arr.get(p1);
                p1++;
            }
        }
        return maxSum;
    }
}
