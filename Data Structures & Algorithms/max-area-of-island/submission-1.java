class Solution {
    public int ROWS = 0;
    public int COLS = 0;
    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        int max = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int count = 0;
                    count =findIsland(grid, i, j, visited);
                    max = count > max ? count : max;
                }
            }
        }
        return max;
    }

    public int findIsland(int[][] grid, int r, int c, boolean[][] visited) {
       //System.out.println("before" + r + " " + c + " count" + count );
        if (r >= ROWS || c >= COLS || r < 0 || c < 0 || grid[r][c] == 0 || visited[r][c] ) {
            //System.out.println("invalid" + r + " " + c+ " count" + count);
            return 0;
        }
        ///System.out.println("after" + r + " " + c);
        visited[r][c] = true;
        int count = 1;
        count += findIsland(grid, r + 1, c, visited);
        count += findIsland(grid, r, c + 1, visited);
        count += findIsland(grid, r - 1, c, visited);
        count += findIsland(grid, r, c - 1, visited);
        return count;
    }
}
