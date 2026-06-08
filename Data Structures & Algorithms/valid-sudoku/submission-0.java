class Solution {
    public boolean isValidSudoku(char[][] board) {
        int i,j, n = board.length, m = board[0].length;
        ArrayList<HashSet<Integer>>row = new ArrayList<>();
        ArrayList<HashSet<Integer>>col = new ArrayList<>();
        ArrayList<HashSet<Integer>>subMat = new ArrayList<>();
        for(i=0;i<n;i++) {
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            subMat.add(new HashSet<>());
        }
        for(i=0;i<n;i++) {
            for(j=0;j<m;j++) {
                if(board[i][j] == '.') continue;
                int x = board[i][j] - '0';
                if(row.get(i).contains(x)) {
                    return false;
                }
                row.get(i).add(x);
                if(col.get(j).contains(x)) {
                    return false;
                }
                col.get(j).add(x);
                int idx = (i/3)*3 + j/3;
                if(subMat.get(idx).contains(x)) {
                    return false;
                }
                subMat.get(idx).add(x);
            }
        }
        return true;
    }
}
