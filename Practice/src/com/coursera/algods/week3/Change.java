package com.coursera.algods.week3;
import java.util.Scanner;

public class Change {
	private static int[] denom = {10, 5, 1};
    private static int getChange(int m) {
    	int count = 0;
    	for (int i = 0; i < denom.length; i++) {
			if(denom[i] > m) {
				continue;
			}else {
				int coins = m / denom[i];
				count += coins ; 
				m = m - coins * denom[i];
			}
		}
    	
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
        scanner.close();
    }
}

