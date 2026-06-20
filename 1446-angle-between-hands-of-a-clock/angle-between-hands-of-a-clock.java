class Solution {
    public double angleClock(int hour, int minutes) {
         int oneMinDeg =6;
         if (hour ==12 )
         hour=0;
         double angle = minutes*oneMinDeg - (hour *5 *oneMinDeg) -( (double)minutes/2 );

        angle = Math.abs(angle);

        return angle>180?360-angle:angle;
    }
}