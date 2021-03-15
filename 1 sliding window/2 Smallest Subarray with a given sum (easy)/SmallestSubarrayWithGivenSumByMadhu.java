import java.util.Random;

public class SmallestSubarrayWithGivenSumByMadhu {

	 public static int findMinSubArrayByBruteForce(int S, int[] arr) {
		 int len = Integer.MAX_VALUE;
		 for (int i = 0; i< arr.length; i++) {
			 
			 int winsum = 0;
			 
			 for (int j = i; j < arr.length; j++) {
				 
				 winsum += arr[j];
				 if(winsum >= S)
				 {
					 len = j - i +1 < len ? j - i +1 : len;
				 }
			 }
		 }
		 
		 return len;
	 }
	 
	 public static int findMinSubArrayBySliding(int S, int[] arr) {
		 
		 int len = Integer.MAX_VALUE;
		 
		 int winStart = 0;
		 int winEnd = 0;
		 int currWinSum = 0;
		 
		 while (winStart < arr.length && winEnd < arr.length) {
			 currWinSum += arr[winEnd];  // expand window 
			 while (currWinSum >= S) {
				 len = winEnd - winStart + 1 < len ? winEnd - winStart + 1 : len;
				 // shrink window by 1 from front
				 currWinSum -= arr[winStart]; 
				 winStart++;
			 }
			 winEnd++;
		 }
		 
		 return len < Integer.MAX_VALUE ? len : 0;
	 }
	 
	 
	public static void main(String[] args) {
//	    int result = SmallestSubarrayWithGivenSumByMadhu.findMinSubArrayBySliding(7, new int[] { 2, 1, 5, 2, 3, 2 });
//	    System.out.println("Smallest subarray length: " + result);
//	    result = SmallestSubarrayWithGivenSumByMadhu.findMinSubArrayBySliding(7, new int[] { 2, 1, 5, 2, 8 });
//	    System.out.println("Smallest subarray length: " + result);
//	    result = SmallestSubarrayWithGivenSumByMadhu.findMinSubArrayBySliding(8, new int[] { 3, 4, 1, 1, 6 });
//	    System.out.println("Smallest subarray length: " + result);
		int arr[] = SmallestSubarrayWithGivenSumByMadhu.testCase(1000);
		
		int result = SmallestSubarrayWithGivenSumByMadhu.findMinSubArrayBySliding(5000,arr);
		System.out.println("Smallest subarray length: " + result);
		
		result = SmallestSubarrayWithGivenSumByMadhu.findMinSubArrayByBruteForce(5000, arr);
		System.out.println("Smallest subarray length: " + result);
	  }
	
	public static int [] testCase(int n) {
		int arr[] = new int[n];
		Random r = new Random();
		for (int i = 0; i< n; i++) {
			arr[i] = r.nextInt(n+1);
		}
		
		return arr;
	}
}
