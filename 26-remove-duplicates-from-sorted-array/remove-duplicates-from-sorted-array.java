class Solution {
    public int removeDuplicates(int[] nums) {


        if (nums.length ==1 )
        return 1 ;
        int start  =0 ;
        int  end =  1 ;

        int count =1;
        while (end < nums.length){
            while (end <nums.length && nums[end] == nums[start ]){
                end ++;
            }
            if(end <nums.length)
            nums[++start] =nums[end];
            count ++;
            

        }
    
        return count-1;
    }
}