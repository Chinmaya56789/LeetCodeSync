class Solution {
    public String minWindow(String s, String t) {
        Map<Character , Integer> map  = new HashMap<>();
        Map<Character , Integer> map2 = new HashMap<>();
        int l =0 , r =0;
        int length = Integer.MAX_VALUE; 
        String  ans = ""; 
        for (char c  : t.toCharArray()){
            map.put(c , map.getOrDefault(c ,0)+1);
        }

        
        while (r < s.length()){

            char c = s.charAt(r);

            if (map.containsKey(c))
            map2.put(c , map2.getOrDefault(c ,0)+1);

            //  System.out.println(" OUT map2 :" +map2 +" l :" +l +" r:"+ r + " ans : " +ans +" cpmpare :" +mapCompare(map , map2 ) ) ;
            
            while(mapCompare(map , map2 ) && l <= r  ){


               
                if (map.containsKey(s.charAt(l))  ){

                    map2.put(s.charAt(l) ,map2.get(s.charAt(l))-1);

                    if (length> r-l +1 ) {
                        ans =s.substring (l ,r+1 );
                    length = ans.length();
                    }
                    

                    

                }
                     

                     l++;

                    //   System.out.println("In map2 : " +map2 +" l :" +l +" r:"+ r + " ans : " +ans ) ;
            }

            r++;
        }
        return ans ;

    }


    public static boolean mapCompare(Map<Character , Integer > map1 ,Map<Character , Integer > map2){
        for (Map.Entry<Character , Integer> entry : map1.entrySet()){
            int val = entry.getValue();

            if (!map2.containsKey(entry.getKey()) || map2.get(entry.getKey()) < val)
            return false ;

        }

        return true ;
    }
}