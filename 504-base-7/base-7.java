class Solution {
    public String convertToBase7(int num) {

        if(num ==0)
        return "0";
        StringBuilder sb = new StringBuilder();
        boolean neg=false ;
        if (num <0 )
        neg =true;
        while(num != 0 ){
            int rem = num %7 ;
            sb.append(Math.abs(rem));

            num= num /7;
        }
        return neg ? "-" +sb.reverse().toString():sb.reverse().toString();
    }
}