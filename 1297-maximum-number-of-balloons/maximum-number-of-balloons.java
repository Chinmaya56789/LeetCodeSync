class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character ,Integer> map = new HashMap<>();
        map.put('b',0);
        map.put('a',0);
        map.put('l',0);
        map.put('o',0);
        map.put('n',0);



        for (char c : text.toCharArray()){
            if(map.containsKey(c)){
                int val = map.get(c);
                map.put(c, val + 1);
            }
        }

        int min =Integer.MAX_VALUE;

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            char c = entry.getKey();
            int val = entry.getValue();
            if ( c  =='l' || c =='o' )
                val =val /2;
            
            if (val < min)
                min =val;
        }
        return min;

    }
}