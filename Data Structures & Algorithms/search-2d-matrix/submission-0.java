class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length, i,j=0;
        i = n-1;
        while(i>=0 && j<m) {
            int x = matrix[i][j];
            if(x == target)return true;
            if(x<target) j++;
            else i--;
        }
        return false;
    }
}
