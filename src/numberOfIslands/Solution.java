package numberOfIslands;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class Solution {

    public int numIslands(char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int num = 0;
        for (int row = 0; row < nr; row++) {
            for (int column = 0; column < nc; column++) {
                if (grid[row][column] == '1') {
                    num++;
                    dfs(grid, row, column);
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid, int row, int column) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (row < 0 || column < 0 || row >= nr || column >= nc || grid[row][column] == '0') {
            return;
        }
        grid[row][column] = '0';
        dfs(grid, row - 1, column);
        dfs(grid, row + 1, column);
        dfs(grid, row, column - 1);
        dfs(grid, row, column + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(solution.numIslands(grid1));

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(solution.numIslands(grid2));

    }
}
