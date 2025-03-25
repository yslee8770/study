package com.example.algorithm.basic;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int total = m;
        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (total == 0) {
                break;
            }
            if (arr[i] <= m) {
                int count = total / arr[i];
                answer += count;
                total -= arr[i] * count;
            }

        }
        System.out.println(answer);
    }

}
