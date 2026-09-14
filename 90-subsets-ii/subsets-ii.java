class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        int lastIterations=0;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        ans.add(new ArrayList<Integer>());

        for (int  i=0 ;i<nums.length ;i++){
            List<List<Integer>> temp = new ArrayList<List<Integer>> (ans);
            int startIndex =0 ;
            
            if( i >0 && nums[i] ==nums[i-1]){
                startIndex = temp.size() - lastIterations;
                System.out.println(startIndex);
            }
            lastIterations =0;    
            for (int j = startIndex ; j< temp.size() ;j++){
                List<Integer> subTemp = new ArrayList<>(temp.get(j));
                subTemp.add(nums[i]);
                ans.add(subTemp);
                lastIterations++;
            }
        }

        return ans;
    }
}