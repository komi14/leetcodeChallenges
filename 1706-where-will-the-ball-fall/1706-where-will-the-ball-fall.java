class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans[] = new int[n];
        for(int c = 0;c < n;c++){
            int answer = c;
            for(int r = 0;r < m;r++){
                if(grid[r][answer] == -1 && answer > 0 && grid[r][answer - 1] == grid[r][answer]){
                    --answer;
                }
                else if(grid[r][answer] == 1 && answer < n - 1 && grid[r][answer + 1] == grid[r][answer]){
                    ++answer;
                }
                else{
                    answer = -1;
                    break;
                }
            }
            ans[c] = answer;
        }
        return ans;
    }
}