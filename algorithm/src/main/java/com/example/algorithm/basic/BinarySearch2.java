package com.example.algorithm.basic;

import java.util.*;

public class BinarySearch2 {
    public long solution(int n, int[] times) {

        long left = 1;
        long right = (long) Arrays.stream(times).max().getAsInt() * n;

        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long processed = getProcessedPeople(mid,times);

            if (processed >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }




        return answer;

    }

    long getProcessedPeople(long time, int[] times) {
        long total = 0;
        for (int t : times) {
            total += time / t;
        }
        return total;
    }
}
