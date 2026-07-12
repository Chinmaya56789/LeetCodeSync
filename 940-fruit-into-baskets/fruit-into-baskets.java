class Solution {
    public int totalFruit(int[] fruits) {
        int i= 0; 
        int j =0 ;
        int max = 0;
        int ans = Integer.MIN_VALUE;
        Map<Integer , Integer> map  = new HashMap<>();
        while (i < fruits.length){
            int type = fruits[i];
            map.put(type , map.getOrDefault(type ,0)+1);
            i++;
            max ++;
            while(map.size()>2){
                type = fruits[j];
                if (map.get(type)!=1 )
                    map.put(type , map.get(type)-1);
                else 
                    map.remove(type);

                j++;
                max--;
            }

            ans = Math.max(max , ans);

        }

        return ans ;
    }
}