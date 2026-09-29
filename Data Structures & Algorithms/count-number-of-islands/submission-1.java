class Solution {
    public int ROWS = 0;
    public int COLS = 0;
    
    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        int islandCount = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    findIsland(grid, i, j, visited);
                    islandCount += 1;
                }
            }
        }
        return islandCount;
    }
    public void findIsland(char[][] grid, int r, int c, boolean[][] visited) {
        //System.out.println("before" + r + " " + c);
        if (r >= ROWS || c >= COLS || r < 0 || c < 0 || grid[r][c] == '0' || visited[r][c] ) {
            //System.out.println("invalid" + r + " " + c);
            return;
        }
        //System.out.println("after" + r + " " + c);
        visited[r][c] = true;
        findIsland(grid, r + 1, c, visited);
        findIsland(grid, r, c + 1, visited);
        findIsland(grid, r - 1, c, visited);
        findIsland(grid, r, c - 1, visited);
    }
}
