class Solution {
    public int minimumCost(int[] cost) {

        int ans =0;
        Arrays.sort(cost);
        int index = cost.length-2;

        if (cost.length==1)
        return cost[0];

        for(int  i =cost.length-2 ;i>=0 ;i=i-3){
            index=i ;
            ans+=cost[index ]+cost[index+1];
            
        }     
        if (index >1)
        ans+=cost[0];

        return ans;
    }
}