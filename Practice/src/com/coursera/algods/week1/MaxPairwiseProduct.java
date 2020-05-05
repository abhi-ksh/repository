package com.coursera.algods.week1;

import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        long[] topTwo = {0, 0};
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
            if(numbers[i] >= topTwo[0] ) {
            	topTwo[1] = topTwo[0];
            	topTwo[0] = numbers[i];
            } else if (numbers[i] >= topTwo[1]) {
            	topTwo[1] = numbers[i];
            }
        }
        System.out.println(topTwo[0] * topTwo[1]);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}