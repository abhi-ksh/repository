package com.coursera.algods.week2;

import java.util.Scanner;

public class Fibonacci {
  static long [] fibArray = new long[46];
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;
    
    if(fibArray[n] > 0) {
    	return fibArray[n];
    }
    
    fibArray[n] = calc_fib(n - 1) + calc_fib(n - 2);
    return fibArray[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
