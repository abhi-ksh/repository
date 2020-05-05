package com.coursera.algods.week2;
import java.util.*;
public class LCM {
  private static long lcm_euclidian(int a, int b) {
	  	long _a = a;
	  	long _b = b;
	  	long product = _a * _b;
	  	int gcd = gcd_euclidian(a, b);
	  	long _gcd = gcd;
	  	System.out.println("A: " + a + " B: " + b + " Product: "+ product);
	    return (product / _gcd);
  }  
  
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

    System.out.println(lcm_euclidian(a, b));
  }
}
