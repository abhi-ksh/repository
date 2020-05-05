package com.coursera.algods.week2;
import java.util.*;

public class GCD {
//  private static int gcd_naive(int a, int b) {
//    int current_gcd = 1;
//    for(int d = 2; d <= a && d <= b; ++d) {
//      if (a % d == 0 && b % d == 0) {
//        if (d > current_gcd) {
//          current_gcd = d;
//        }
//      }
//    }
//
//    return current_gcd;
//  }
  
  private static int gcd_euclidian(int a, int b) {
	  int new_a = a;
	  int new_b = b;
	  int temp;
	  
	  while(new_b != 0) {
		  temp = new_b;
		  new_b = new_a % new_b;
		  new_a = temp;
	  }
	  
	  return new_a;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_euclidian(a, b));
  }
}
