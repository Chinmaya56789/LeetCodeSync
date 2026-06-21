class Solution {
    public int largestAltitude(int[] gain) {
        int high =0 ;
        int run =0;
        for (int i : gain){
            run += i;
            if(run >high)
            high =run ;
        }

        return high ;
    }
}