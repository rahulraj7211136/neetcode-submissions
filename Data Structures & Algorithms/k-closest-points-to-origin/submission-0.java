class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (int []a, int []b) -> {
            Long x = 1L * a[0] * a[0] + 1L * a[1] * a[1]; 
            Long y = 1L * b[0] * b[0] + 1L * b[1] * b[1];
            return x < y ? -1 : 1; 
        });
        return Arrays.copyOf(points, k);
    }
}
