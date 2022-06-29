package hello.algorithm.dynamicprogramming;
import  java.io.*;

public class DpEight {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());

            int[][] stickers = new int[2][n+1];
            int[][] dp = new int[2][n+1];

            //2행 n열, stickers에 n개의 값 저장
            for(int j=0; j<2; j++){
                String[] inputs = br.readLine().split(" ");
                for(int k = 1; k<=n; k++){
                    stickers[j][k] = Integer.parseInt(inputs[k-1]);
                }
            }

            //첫번째 열은 자기 자신이 최대이므로 자기자신으로 초기화
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            //스티커 문제 점화식
            for(int j = 2; j<=n; j++){
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + stickers[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + stickers[1][j];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));

        }

        }
    }
