class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans =0 ;
        for( int i =num1 ;i <= num2 ;i++){
            ans+= getWave(i);
        }
        return ans;
    }

    public int getWave(int num){
        String s = String.valueOf(num);
        int ans =0;
        for (int i=1 ;i <s.length()-1;i++){
            if(s.charAt(i-1) > s.charAt(i) &&  s.charAt(i+1) >s.charAt(i))
            ans++;
            if(s.charAt(i-1) < s.charAt(i) &&  s.charAt(i+1) < s.charAt(i))
            ans++;
        }
        return ans ;
    }
}