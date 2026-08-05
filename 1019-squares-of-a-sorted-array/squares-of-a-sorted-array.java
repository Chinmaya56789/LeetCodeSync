class Solution {
    public int[] sortedSquares(int[] nums) {
         int[] ans = new int[nums.length];
         

         int len = nums.length -1 ;
         int start =0 , end =len;
    
         while (end >= start ){

            int s = nums[start]*nums[start];
            int e = nums[end]*nums[end];
            if (s >e ){
                ans [len ]= s;
                start ++;
            }
                
            else {
                ans[len ] =e ;
                end --;
            }

            len --;
         }

         return ans ;


    }
}