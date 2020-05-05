package com.coursera.algods.week2;

import java.util.*;
public class FiboHuge {
   


	private static long getFibonacciNotHugeButFast(long n, long m){
  	long i=0;//periodicity 
		if (n <= 1){
      		return n;
     }else{
			  long previous = 0;
      	     long current  = 1;
			  while(true){
				  if(i!=0&&previous==0&&current==1){
					    break;
				  }else{
					        long tmp_previous = previous%m;
            			previous = current%m;
         			  	current = tmp_previous + current;
					        if(current>=m)
						          current=current%m;// adding the mod of previous two numbers and if the no is more than   "m" then take mod of it .	          
					        i++;//Iteration for periodicity
			  	}
			    };
			//System.out.println(i); 
			return getFibonacciHugeButSlow( n%i,m);//IT is equal to F(n%i)%m
			
	     }
    }

	 private static long getFibonacciHugeButSlow(long n, long m){

        	if (n <= 1)
      		      return n;
     	    else{
			        long i=0;
			        long previous = 0;
      	      long current  = 1;
	          	for ( i = 0; i < n - 1; ++i) {
            		long tmp_previous = previous%m;
            		previous = current%m;
         			  current = tmp_previous + current;// adding the mod of previous two numbers and if the no is more than   "m" then take mod of it .
			        	if(current>=m){
				          	current=current%m;	          
			       	}
			}
			//System.out.println(i);
			return current;
	     }
    }
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciNotHugeButFast(n, m));
    }
}