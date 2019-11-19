package dp;

public class MinimumCostPath {

    static int min(int x, int y, int z){
        if(x < y){
            return (x < z) ? x : z;
        }else{
            return (y < z) ? y : z;
        }
    }

    static int minCost(int cost[][], int m, int n){
        if(n < 0 || m < 0){
            return Integer.MAX_VALUE;
        }else if(m == 0 && n == 0){
            return cost[m][n];
        }else{
            return cost[m][n] +
                    min(
                            minCost(cost, m - 1, n - 1),
                            minCost(cost, m - 1, n),
                            minCost(cost, m, n - 1));
        }
    }

    static int minCostDP_tabulation(int cost[][], int m, int n){
        int i, j;
        int dp[][] = new int[m + 1][n + 1];

        dp[0][0] = cost[0][0];

        for(i = 1; i <= m; i++){
            dp[i][0] = dp[i - 1][0] + cost[i][0];
        }

        for(j = 1; j <= n; j++){
            dp[0][j] = dp[0][j - 1] + cost[0][j];
        }

        for(i = 1; i <= m; i++){
            for(j = 1; j <= n; j++){
                dp[i][j] = min(
                        dp[i - 1][j - 1],
                        dp[i - 1][j],
                        dp[i][j - 1]
                              ) + cost[i][j];
            }
        }

        return dp[m][n];
    }

    static int[][] tc = null;
    static int V;
    static int minCostDP_memoization(int cost[][], int m, int n){

        if(m > cost.length || n > cost.length)
            return 0;

        if(m < 0 || n < 0){
            return 0;
        }else{
            return min(
                    minCostDP_memoization(cost, m + 1, n),
                    minCostDP_memoization(cost, m, n + 1),
                    minCostDP_memoization(cost, m + 1, n + 1)
            ) + cost[m][n];
        }
    }

    public static void main(String[] args) {

        int cost[][] = {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        };
        tc = new int[3][3];
        System.out.println(minCostDP_memoization(cost, 0, 0));
    }


}
