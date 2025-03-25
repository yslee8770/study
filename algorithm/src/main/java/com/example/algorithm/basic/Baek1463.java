package com.example.algorithm.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int[] dp = new int[x + 1];
        dp[1] = 0; // 1은 연산이 0번

        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + 1; // 기본적으로 -1 연산

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.println("\n최소 연산 횟수: " + dp[x]);
    }

}
