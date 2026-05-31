import java.util.Arrays;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        // Use a long to prevent integer overflow during accumulation
        long currentMass = mass; 

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > currentMass) {
                return false;
            }
            currentMass += asteroids[i];
        }

        return true;
    }
}