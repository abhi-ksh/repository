package com.coursera.algods.week4;
import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
    
        int mid = (left + right) /2 ;
        
        int leftR = getMajorityElement(a, left, mid);
        int rightR = getMajorityElement(a, mid , right);
        
        if (leftR == rightR) {
        	return leftR;
        }
        
        int leftCount = getCount(a, leftR, left, right);
        int rightCount = getCount(a, rightR, left, right);
        
        if (leftCount == rightCount) {
        	return -1;
        }
        
        int majority = (right - left  )/ 2 + 1 ;
        
        if(leftCount >= majority) {
        	return leftR;
        } else if( rightCount >= majority){
        	return rightR;
        }
        
        return -1;
    }

    private static int getCount(int[] a, int num, int left, int right) {
    	int count  = 0;
    	if(num == -1) {
    		return 0;
    	}
    	for (int i = left; i < right; i++) {
			if(a[i] == num) {
				count++;
			}
		}
    	return count;
	}

	public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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

