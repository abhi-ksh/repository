package com.coursera.algods.week2;

import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 0;
        long m = 10;
        //get paisano period
        ArrayList<Long> pisano = new ArrayList<>();
        pisano.add(0L);
        pisano.add(1L);
        long pisano_period = 1L;
        
        while (true) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;
            
            if (current > m ) {
            	current = current % m ;
            }
            pisano.add(current);
            if(previous == 0L && current == 1L) {
            	break;
            }
//            sum += current;
            pisano_period++;
        }        	        
//        System.out.println("Sum :" + sum);
        
        long mod = (n % pisano_period);
//        sum = ((n / m ) * sum) % 10;
//        System.out.println("Sum :" + sum);
        
        for (int i = 0; i <= mod; ++i) {   
            sum += pisano.get(i) ;
        }

        return sum % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

