class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0;
        int sum =0; 

        for (int i  : nums ){
            sum+=i;
        }

        for (int i =0 ;i<nums.length ;i++){
            ans[i]= Math.abs((2*left)-sum +nums[i]);
            left+=nums[i];
        }

        return ans;
    }
}