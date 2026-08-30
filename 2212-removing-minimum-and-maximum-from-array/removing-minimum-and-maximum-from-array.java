class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int len = nums.length;

        int minLen =0 ,maxLen =0;

        for (int i =0 ;i <nums.length ;i++){
            if (nums[i]>max){
                maxLen =i;
                max = nums[i];
            }

            if (nums[i]< min){
                minLen = i;
                min = nums[i];
            }
        }

        int big = Math.max(maxLen ,minLen) +1 ;
        int small = len - Math.min(maxLen ,minLen);
        int med = 1 +  Math.min (maxLen ,minLen ) + len - Math.max(maxLen ,minLen); 
        

        return  Math.min (Math.min( big ,small) ,med );
    }
}