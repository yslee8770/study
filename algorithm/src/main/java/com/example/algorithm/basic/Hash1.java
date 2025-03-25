package com.example.algorithm.basic;

import java.io.*;
import java.util.*;

public class Hash1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> findByNameMap = new HashMap<>();
        Map<Integer, String> findByNumberMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            String value = br.readLine();
            findByNumberMap.put(i, value);
            findByNameMap.put(value, i);
        }

        for (int i = 1; i <= m; i++) {
            String checkValue = br.readLine();
            if (checkValue.charAt(0) < '0' || checkValue.charAt(0) > '9') {
                sb.append(findByNameMap.get(checkValue)).append('\n');
            } else {
                sb.append(findByNumberMap.get(Integer.parseInt(checkValue))).append('\n');
            }
        }
        System.out.print(sb);
    }

}
