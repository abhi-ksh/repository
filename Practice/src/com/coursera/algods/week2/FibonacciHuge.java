package com.coursera.algods.week2;
import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugePaisano(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0L;
        long current  = 1L;
        //get paisano period
        ArrayList<Long> pisano = new ArrayList<>();
        pisano.add(0L);
        pisano.add(1L);
        long pisano_period = 1L;
        
        //this is the key.. we need to go only up to m for computing pisano period.
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
            pisano_period++;
        }        	
        
//        System.out.println("Pisano period: " + pisano_period + "AL size:" + pisano.size());
        long mod =  (n % pisano_period);
        
        return pisano.get((int)mod);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugePaisano(n, m));
        scanner.close();
    }
}

