package hello.algorithm.dynamicprogramming;
import java.io.*;
/*
* 백준 오르막수(11057)
* */

public class DpSix {
    static int[][] dp;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][10];
        for(int i = 0; i<10; i++){
            dp[1][i] = 1;
        }
        for(int i =2; i<=n; i++){
            for(int j=0; j < 10; j++){
                for(int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        int sum = 0;
        for(int i=0; i<10; i++){
            sum += dp[n][i];
        }

        System.out.println(sum%10007);
    }
}



