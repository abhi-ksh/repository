package com.coursera.algods.week3;
import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
    	int numRefills = 0;
    	int distanceRemaining = dist;
    	int fuelRemaining = tank;
    	int lastRefill = 0;
    	
//    	950
//    	400
//    	4
//    	200 375 550 750
    	
    	for (int i = 0; i < stops.length; i++ ) {
    		if (fuelRemaining >= (stops[i] - lastRefill)) {
    			fuelRemaining -= (stops[i] - lastRefill);
    			distanceRemaining -= (stops[i] - lastRefill);
    		}
    		
    		if(i == stops.length - 1) {
				if (distanceRemaining > tank) {
					// impossible to cover the distance
					return -1;
				} else {
					if(distanceRemaining <= fuelRemaining) {
						return numRefills;
					} 
					
					numRefills++;
				}
    		} else {
        		// check next gas station distance to decide whether to fuel.
        		//  and only fuel when it's impossible to go to next one
        		if((stops[i+1] - stops[i])> fuelRemaining) {
        			// refill here
        			numRefills++; 
        			fuelRemaining = tank;
        		}     			
    			lastRefill = stops[i];
        		
    		}
    		
    	}
        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
