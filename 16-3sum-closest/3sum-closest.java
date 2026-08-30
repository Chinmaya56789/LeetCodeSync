class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closeSum = Integer.MAX_VALUE;


        if (nums.length ==3 )
        return nums[0] +nums[1] +nums[2];
         Arrays.sort(nums);

        for (int i =0 ; i< nums.length ;i ++){
            if (i > 0 && nums[i] ==nums[i-1])
            continue;
            int  start  = i+1 ; 
            int end = nums.length -1 ;
            while (start < end  && end < nums.length){
                int localSum = nums[i] + nums[start] +nums[end];
                if ( Math.abs (localSum - target )< Math.abs (closeSum -target ))  {
                closeSum = localSum ;
                }
                else if (target  -localSum <= 0 )
                end --;
                else
                start ++;

            }
        }


        return closeSum ;
    }
}