package com.coursera.algods.week2;
import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSum(long from, long to) {
   
        long previous = 0;
        long current  = 1;
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
        
        long mod_lower = (from % pisano_period);
        long mod_upper = (to % pisano_period);
//        sum = ((n / m ) * sum) % 10;
//        System.out.println("Sum :" + sum);
        long sum_upper = 0;
        
        for (int i = 0; i <= mod_upper; ++i) {   
        	sum_upper += pisano.get(i) ;
        	if (sum_upper> 10) 
        		sum_upper %= 10;
        }
//        sum_upper = sum_upper % 10;
        System.out.println("Upper: " + sum_upper );
        
        long sum_lower = 0;
        for (int i = 0; i <= mod_lower - 1; ++i) {   
        	sum_lower += pisano.get(i) ;
        	if (sum_lower > 10)
        		sum_lower %= 10;
        }        
        System.out.println("Lower: " + sum_lower );
        long sum = (sum_upper - sum_lower) % 10;
        if (sum < 0) {
        	sum += 10;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}

