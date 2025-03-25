package com.example.algorithm.basic;

import java.io.*;
import java.util.*;

public class BinarySearch1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int low = 1;
        int high = house[N - 1] - house[0];
        int answer = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canInstall(house, mid, C)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        System.out.println(answer);
    }

    public static boolean canInstall(int[] house, int distance, int c) {
        int count = 1;
        int last = house[0];

        for (int i = 1; i < house.length; i++) {
            if (house[i] - last >= distance) {
                count++;
                last = house[i];
            }
        }
        return count >= c;
    }
}
