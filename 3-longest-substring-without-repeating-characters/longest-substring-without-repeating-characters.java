class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.length()==0)
        return 0;
        int i =0 ,j =0;

        int max =0 , ans = Integer.MIN_VALUE;

        Set<Character> set = new HashSet<Character>();



        while (i <s.length()){
            char  c = s.charAt(i);
            max ++;
            i++;
            while(set.contains(c)){
                set.remove(s.charAt(j));
                j++;
                max --;
            }
            set.add(c);
            ans = Math.max(ans ,max );

        }

        return ans ;
    }
}