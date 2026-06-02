class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
    int n = landStartTime.length;
    int m = waterStartTime.length;


    int landride = Integer.MAX_VALUE;
    int opt1 = Integer.MAX_VALUE;

    for (int i =0 ;i<n ;i++){
        landride= Math.min(landride , landDuration[i] +landStartTime[i]);
    }

        for (int i =0 ;i<m ;i++){
            opt1 = Math.min(
                Math.max(landride,waterStartTime[i] ) + waterDuration[i], opt1

            );
        }

        landride = Integer.MAX_VALUE;
        int opt2 = Integer.MAX_VALUE;

        for (int i =0 ;i<m ;i++){
        landride= Math.min(landride , waterStartTime[i] +waterDuration[i]);
    }

        for (int i =0 ;i<n ;i++){
            opt2 = Math.min(
                Math.max(landride,landStartTime[i] ) +landDuration[i] , opt2 );
        }

        return Math.min(opt1, opt2);
    }
}