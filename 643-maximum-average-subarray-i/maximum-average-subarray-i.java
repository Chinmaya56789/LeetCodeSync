class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int i =0 ;

        double sum =0  ;
        double max =Integer.MIN_VALUE;

        while (i <nums.length){
            

            if ( i >=k ){
                if (sum/k >max )
                    max = sum/k;
            sum -= nums[i-k];
            
            }
            sum += nums[i];
            i++;
        }

        if (sum/k >max )
            max = sum/k;

        return max ;
    }
}