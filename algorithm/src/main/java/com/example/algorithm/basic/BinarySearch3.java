package com.example.algorithm.basic;

import java.io.*;
import java.util.*;

public class BinarySearch3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st1.nextToken());
        }

        int low = 0;
        int high = Arrays.stream(trees).max().getAsInt();
        int answer = 0;
        while (low <= high) {
            int mid = (high + low) / 2;

            if (getTreeCheck(trees, mid, M)) {
                low = mid + 1;
                answer = mid;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean getTreeCheck(int[] trees, int length, int M) {
        long count = 0;
        for (int tree : trees) {
            if (tree > length) {
                count += (tree - length);
            }
        }
        return count >= M;
    }
}


