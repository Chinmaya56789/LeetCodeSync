class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        

        for(int i : nums){
            int size = ans.size();
            for ( int j =0 ; j <size ; j++ ){
                List<Integer> a =new ArrayList<Integer> ( ans.get(j));
                a.add(i);
                ans.add(a);
            }
            ans.add(Arrays.asList(i));
        }       

        ans.add(new ArrayList<>());

        return ans ;
    }
}