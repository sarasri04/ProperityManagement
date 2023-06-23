package com.market.simplified.test;

import java.util.Comparator;

public class exercise2 {
	// method name must be: countGreaterItems(T[] items, T item) !!! 
	
	public static <T extends Comparable<T>> T countGreaterItems(T[] items, T item) {
		
		for(T it : items) {
			if(it.compareTo(item)<0) {
				System.out.println("print value:"+it);
				return it;
			}
			
			
		}
		
		return item;
		
	}
	
	public static void main(String args[]) {
		
		Integer[] ite = {20,30,40};
		countGreaterItems(ite,20);
		
	}

	
	
}
