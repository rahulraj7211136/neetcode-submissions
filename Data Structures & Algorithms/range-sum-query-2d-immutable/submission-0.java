class NumMatrix {
    private int[][] dp;
    public NumMatrix(int[][] matrix) {
        int i,j,n = matrix.length, m = matrix[0].length;
        dp = new int[n][m];
        dp[0][0] = matrix[0][0];
        for(i=1;i<n;i++) {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }
        for(i=1;i<m;i++) {
            dp[0][i] = dp[0][i-1] + matrix[0][i];
        }
        for(i=1;i<n;i++) {
            for(j=1;j<m;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int u = row1-1 >= 0 ? dp[row1-1][col2] : 0;
        int l = col1-1 >= 0 ? dp[row2][col1-1] : 0;
        int d = col1 > 0 && row1 > 0 ? dp[row1-1][col1-1] : 0;
        return dp[row2][col2] + d - u - l;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */