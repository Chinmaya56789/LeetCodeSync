class Solution {
    public int numTrees(int n) {

        Map<Integer ,Integer> memo = new HashMap<>();
        return build(1 , n , memo );
    }

    public int build ( int start , int end , Map<Integer , Integer > map ){
        int ans =0;

        if ( start >end ){
            return  1 ;
        }

        if (map.containsKey(end -start))
        return  map.get(end -start );

        for (int i = start ; i<=end  ;i ++ ){
            int left =  build(start , i -1 ,map );
            int right = build (i+1 , end ,map ); 
            ans += left *right ;
        }

        map.put( end -start  , ans  );
        return ans ;
    }
}