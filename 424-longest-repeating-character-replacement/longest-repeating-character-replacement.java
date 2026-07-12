class Solution {
    public int characterReplacement(String s, int k) {
        int i =0 ;
         int j =0 ;
         char maxc=0;
         int maxcount =0;
         int ans = Integer.MIN_VALUE;
         Map<Character,Integer> map = new HashMap<>();
         int total =0;


         while (i < s.length()){
            char c = s.charAt(i);
            int  temp = map.getOrDefault(c ,0);
             map.put(c ,++temp);
            if (temp > maxcount){
                maxc = c ;
                maxcount =temp;
            }
            i++;

            total++;
            while(j <s.length() && k < (total-maxcount)){
                c = s.charAt(j);
                temp = map.get(c);
                map.put (c ,--temp);
                if (c == maxc){
                    for(char ct :map.keySet()){
                        if (maxcount < map.get(ct)){
                            maxc = ct ;
                            maxcount = map.get(ct);
                        }
                    }
                }
                total--;
                j++;
                
            }
        ans = Math.max(ans , i -j);



         }

         return ans;
    }
}