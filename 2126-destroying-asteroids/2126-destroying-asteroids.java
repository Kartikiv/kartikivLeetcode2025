class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // sort the asteroids 
        Arrays.sort(asteroids);
        long massLong = mass;

        // if the mass is less the then add the mass else return false
        for (int i = 0; i < asteroids.length; i++) {
            if (massLong < asteroids[i])
                return false;
            // add the massLong of asteriod i 
            massLong += asteroids[i];

        }
        return true;
    }
}