class Solution {
    public int longestOnes(int[] nums, int k) {
         int l =0 ; 
         int r =0 ;
         int count =0; 
         int ans = 0;


         while(r <nums.length){

            int temp  = nums[r];
           
           if( temp ==0){
            count++;
           }

           if (count > k){
            if(nums[l] == 0)
            count --;
            l++;
           }       
            ans = Math.max(ans ,r-l+1);

            r++;

         }

         return ans ;
        
    }
}