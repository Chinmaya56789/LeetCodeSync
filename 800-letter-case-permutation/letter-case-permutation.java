class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<String>();

        backtrack(ans , new StringBuilder(), s.toCharArray() , 0 );
        
        return ans ;
    }

    public void backtrack (List<String> ans  , StringBuilder sb , char[] s ,int index){
        if( sb.length() == s.length){
            ans.add(sb.toString());
            return;
        }
        char c = s[index];

             if (Character.isDigit(c) ){
                sb.append(c);
                backtrack (ans , sb, s ,index +1 );
                sb.deleteCharAt(sb.length()-1 );
             }
             else{         
            c = Character.toUpperCase(c);
            sb.append(c);
            backtrack (ans , sb, s ,index +1 );
            sb.deleteCharAt(sb.length()-1 );

            c = Character.toLowerCase(c);
            sb.append(c);
            backtrack (ans , sb, s ,index +1 );
            sb.deleteCharAt(sb.length()-1 );
             }
        
    }
}