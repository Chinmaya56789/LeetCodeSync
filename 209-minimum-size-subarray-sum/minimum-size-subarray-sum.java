class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        

        int i =0 , j =0;
        int sum =0; 

        int min =Integer.MAX_VALUE ;

        while (j < nums.length ){
            while ( sum >=target){
                if ( min > (j-i))
                    min =j-i;
                sum-= nums[i];
                i++;        
            }
            sum += nums[j];

            System.out.println(sum);

            j++;
        } 

        while ( sum >=target){
                if ( min > (j-i))
                    min =j-i;
                sum-= nums[i];
                i++;        
            }

        return min==Integer.MAX_VALUE ? 0  : min ;
    }
}