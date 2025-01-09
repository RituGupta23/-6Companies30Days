class Maximum_Sum_of_Distinct_Subarrays_With_Length_K {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        int l = 0;
        int r = 0;

     long currSum = 0;
     long maxSum = 0;

        while (r<nums.length) {
            while (set.contains(nums[r])) {
                currSum -= nums[l];
                set.remove(nums[l]);
                l++;
            }

            currSum += nums[r];
            set.add(nums[r]);

            if (r-l+1 == k) {
                maxSum = Math.max(maxSum, currSum);

                currSum -= nums[l];
                set.remove(nums[l]);
                l++;
            }

            r++;
        }

        return maxSum;
    }
}