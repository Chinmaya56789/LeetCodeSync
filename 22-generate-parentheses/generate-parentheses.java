class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        Queue<Character> track = new ArrayDeque<Character>(); 
        char[] curr = new char[n*2];
        int index =0;
        backtrack(ans , curr , track , index);
        return ans ;
    }

    public void  backtrack(List<String> ans , char[] curr , Queue<Character> track , int index ){

        if ( index ==  curr.length){
            if (track.size()==0)
                ans.add(new String(curr));
            return;
        }

        char c = '(';
        track.offer(c);
        curr[index]= c ;
        System.out.println("( "+Arrays.toString(curr));
        backtrack(ans ,curr ,track ,index + 1 );
        track.poll();

        if (track.size()>0){
        c  = ')';
        char removed = track.poll();
        curr[index] = c;
        backtrack(ans ,curr ,track ,index + 1 );
        track.offer(removed); // <-- restore, this was missing


        }
        
    }
}