class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character , Integer > map1 = new HashMap<>();

        Set<Character> set = new HashSet<>();
        int left =0  , right =0;


        for (char c : s1.toCharArray() ){
            map1.put(c , map1.getOrDefault(c , 0)+1);
            set.add(c);
        }

        
        while ( right <s2.length()){
            char c = s2.charAt(right);
            if (set.contains(c)){
                map1.put(c ,map1.getOrDefault(c ,0 )-1);

                if(map1.get(c)==0)
                map1.remove(c);
            }
            right ++;

            //System.out.println("Out : "+ right +" char : "+c +" map : "+ map1 );
            if (right -left >s1.length()){

                c = s2.charAt(left);
                if (set.contains(c)){
                    
                map1.put(c ,map1.getOrDefault(c ,0 )+1);
                if(map1.get(c)==0)
                map1.remove(c);

            }
             left ++;
            //System.out.println("In : "+ left + " map : "+ map1 );
           
            }

            if (map1.size()==0)
            return true;
            
        }


        return false;




    }
}