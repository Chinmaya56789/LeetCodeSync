class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>>  ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i =0 ; i< nums.length ;i ++){
            if (i > 0 && nums[i] ==nums[i-1])
            continue;
            int  start  = i+1 ; 
            int end = nums.length -1 ;
            while (start < end  && end < nums.length){
                int localSum = nums[i] + nums[start] +nums[end];
                if ( localSum == 0){
                    System.out.println( i +" -" + start + " -" + end );
                ans.add (new ArrayList<Integer>(Arrays.asList(nums[i] ,nums[start] ,nums[end] )));
                start ++;
                end --; 
                while ( start  < nums.length &&  nums [start ]  == nums [start -1  ] ){
                    start ++ ;
                }
                while (end > 0 && nums[end ] == nums[end +1  ] ){
                    end --;
                }
                }
                else if (localSum > 0)
                end --;
                else
                start ++;

            }
        }


        return ans ;
        
    }
}