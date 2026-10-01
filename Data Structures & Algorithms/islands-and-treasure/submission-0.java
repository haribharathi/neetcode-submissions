class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        Deque<int[][]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[][]{{i,j}});
                    visited[i][j] = true;
                }
            }
        }
        int count = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //System.out.println(count);
                int[][] cell = queue.poll();
                //System.out.println(cell[0][0] + " " + cell[0][1]);
                List<List<Integer>> nes = Arrays.asList(Arrays.asList(0,1),Arrays.asList(0,-1),Arrays.asList(1,0),Arrays.asList(-1,0));
                if (grid[cell[0][0]][cell[0][1]] == 0) {
                    count = 0;
                }
                if (grid[cell[0][0]][cell[0][1]] > count) {
                    grid[cell[0][0]][cell[0][1]] = count;
                }
                for (List<Integer> each : nes) {
                    int r = each.get(0) + cell[0][0];
                    int c = each.get(1) + cell[0][1];
                    if (r >= ROW || c >= COL || r < 0 || c < 0 || visited[r][c] || grid[r][c] == -1) { //
                        continue;
                    }
                    visited[r][c] = true;
                    queue.add(new int[][]{{r,c}});
                }
            }
            count += 1;
        }
    }
}
