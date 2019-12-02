package dp;

import java.util.Arrays;

public class CoinChange {

    static int count(int[] S, int m, int n){

        if(n == 0){
            return 1;
        }

        if(n < 0){
            return 0;
        }

        if(m <= 0 && n >= 1){
            return 0;
        }

        return count(S, m - 1, n) +
                count(S, m, n - S[m - 1]);
    }

    static long countWays(int S[], int m, int n){

        int[][] table = new int[m + 1][n + 1];

        Arrays.fill(table, 0);

        for(int i = 1; i < m; i++){
            table[0][i] = 1;
        }


        for(int i = 0; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(S[i - 1] > j){
                    table[i][j] = table[i - 1][j];
                }else{
                    table[i][j] = table[i - 1][j] +
                            table[i][j - (i - 1)];
                }
            }
        }

        return table[m][n];
    }

    int countDP(int S[] ,int m, int n){

        int[][] table = new int[m + 1][n + 1];

        Arrays.fill(table, 0);

        for(int i = 0; i < m; i++){
            table[0][i] = 1;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(S[i - 1] > j){
                    table[i][j] = table[i - 1][j];
                }else{
                    table[i][j] = table[i - 1][j] +
                            table[i][j - (i - 1)];
                }
            }
        }

        return table[m][n];
    }



    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        System.out.println(count(arr, m, 4));
        System.out.println(countWays(arr, m, 4));

    }
}
