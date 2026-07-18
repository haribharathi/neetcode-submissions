class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> rowList = new ArrayList<>();
        initialise(rowList);
        List<HashSet<Character>> colList = new ArrayList<>();
        initialise(colList);
        List<HashSet<Character>> squareList = new ArrayList<>();
        initialise(squareList);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                HashSet<Character> rowSet = rowList.get(i);
                if (board[i][j] == '.') {
                    continue;
                }
                if (rowSet.contains(board[i][j])) {
                    return false;
                }
                rowSet.add(board[i][j]);
                HashSet<Character> colSet = colList.get(j);
                if (colSet.contains(board[i][j])) {
                    return false;
                }
                colSet.add(board[i][j]);
                int index =  (i/3)*3 + (j/3);
                HashSet<Character> squareSet = squareList.get(index);
                if (squareSet.contains(board[i][j])) {
                    return false;
                }
                squareSet.add(board[i][j]);
            }
        }
        return true;
    }

    public void initialise(List<HashSet<Character>> list) {
        for (int i = 0; i < 9; i++) {
            list.add(new HashSet<>());
        }
    }

}
