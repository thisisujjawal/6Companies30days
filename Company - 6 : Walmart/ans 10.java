class Solution {
    double r = 0.0, x = 0.0, y = 0.0;
    public Solution(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }
    
    public double[] randPoint() {
        Random random = new Random();
        double temp = Math.sqrt(random.nextDouble()) * r, theta = random.nextDouble() * 2 * Math.PI;
        double ans [] ={ x + temp * Math.cos(theta), y + temp * Math.sin(theta) };
        return ans;
    }
}
