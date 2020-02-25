package cse360assign2;
/**
 * 
 * @author Gary Enea
 * Class ID: 154
 * Assignment #1
 * 
 * File contains SimpleList class along with its five methods and constructor. Two global variables included. 
 *
 */



 //SimpleList will perform multiple different operations on an integer array of up to 10 elements. Operations include add 
 //element, remove element, search element, return amount of elements, and print elements.
public class SimpleList {
	private int[] list;
	private int count; 
	
	
	/*
	 * Constructor method, initializes list to 10 elements, count to 0. 
	 */
	public SimpleList() {
		list = new int[10];
		count = 0; 
	}
	
	
	/**
	 * Adds a new element to the first index of the list regardless. If the list isn't empty, then will shift
	 * elements to the right, will delete the rightmost element. 
	 * 
	 * @param newInt the new integer to be added to the list
	 */
	public void add(int newInt) {
		int increase = 0; 	//amount to increase array
		int[] temp; 
		
		
		if(count == 0) { //when the list is empty
			list[0] = newInt; 
			count++; 
		}
		
		else if (count == list.length){	//when the list is full 
			increase = (int) (list.length * 0.5); 	//set the amount to increase the array
			temp = list;			
			
			list = new int[count + increase]; 	//increase list by 50% 
			
			//copy elements back into array
			for(int index = 0; index < count; index++) {
				list[index + 1] = temp[index];  
			}
			
			list[0] = newInt; 
			count++; 
		}
		
		else {	//when the list isn't full
			for (int index = (count - 1); index >= 0; index--) {
				list[index + 1] = list[index];	//set the next element to the previous element 				
			}
			list[0] = newInt; 
			count++;
		}
		
	}
	
	
	
	/**
	 * Removes all occurrences of an element from the list, will shift all following elements left if the element
	 * exists. If it doesn't exist, the array will be unchanged. **An empty index is denoted by '0'.**   
	 * 
	 * @param key the element to be removed if it exists 
	 */
	public void remove(int key) {
		int locale = search(key);	//index for element to be removed
		int decrease = 0; 			//amount to decrease list by
		int amountEmpty; 		//amount of empty indexes in list
		int[] temp; 
		boolean isLarger = true; 
		int exists = locale; 
		
		while(locale != -1) {
			if(locale == (count - 1)) {	//when element is the last element of the array 
				list[count - 1] = 0; 
				count--;	
		    }
			else {
				for(int index = locale; index < (count - 1); index++) 
					list[index] = list[index + 1];
				list[count - 1] = 0; 
				count--; 
			}
			
			locale = search(key); 
		}
		
		
		while (isLarger && exists != -1) {
			decrease = (int) (list.length * .25); 	//25% of the length of the array
			amountEmpty = 0; 
			
			//count how many empty indexes; empty indexes contain '0'
			for(int index = 0; index < list.length; index++) {
				if(list[index] == 0)
					amountEmpty++; 
			}
			
			//if the amount empty exceeds 25% of the array
			if (amountEmpty > decrease) {
				temp = list; 
				list = new int[list.length - decrease]; 
				
				for (int index = 0; index < count; index++)
					list[index] = temp[index]; 
			}
			
			
			//=================================================
			//check the new array
			//=================================================
			decrease = (int) (list.length * .25); 	//25% of the length of the new array
			amountEmpty = 0; 
			
			//count how many empty indexes in new array; empty indexes contain '0'
			for(int index = 0; index < list.length; index++) {
				if(list[index] == 0)
					amountEmpty++; 
			}
			
			if (amountEmpty <= decrease || list.length == 3)
				isLarger = false; 
		}
	}
	
	
	/**
	 * Returns the amount of elements in a list. 
	 * 
	 * @return the integer value for amount of elements in a list
	 */
	public int count() {
		return count; 
	}
	
	
	
	/**
	 * Returns the length of the array list. 
	 * 
	 * @return the integer value for length of list
	 */
	public int size() {
		return list.length; 
	}
	
	
	/**
	 * Creates a string to print all the elements in the list, adds a space between each element. 
	 * 
	 * @return the array string
	 */
	public String toString() {
		String contents = ""; 
		for(int index = 0; index < count ; index++) {
			contents += list[index] + " "; 
		}
		return contents; 
	}
	
	
	/**
	 * Searches throughout the list for the first occurrence of the given element. If the element exists, will return
	 * the index where it is found. If the element does not exist, will return -1. 
	 *  
	 * @param key the element to search for 
	 * @return the index of the first occurrence of key, or -1
	 */
	public int search(int key) {
		int location = -1; 
		for(int index = 0; index < count ; index++) {
			if (list[index] == key) {
				location = index;
				index += 1000; 		//break to return the first occurrence of key
			}
		}
		return location; 
	}
	
	
	
	/**
	 * Appends an element to the back of the list. If the list is full, will increase the list by 50%
	 * and then append the element 
	 * 
	 * @param appendee the integer to be appended 
	 */
	public void append(int appendee) {
		int[] temp; 
		
		//if list is full
		if(count == list.length) {
			int increase = (int) (list.length * 0.5);
			temp = list; 
			list = new int[count + increase];	//increase array by 50%
					
			for(int index = 0; index < count; index++)
				list[index] = temp[index]; 
					
			//append new int
			list[count] = appendee;
			count++;
		}
		else {
			list[count] = appendee;
			count++;
		}
	}
	
	
	/**
	 * Returns the first element in the list, -1 if the list is empty. 
	 * 
	 * @return either the first element in the list or -1
	 */
	public int first() {
		if(count > 0) 
			return list[0];
		else
			return -1; 
	}
		
		
	
	/**
	 * Returns the last element in the list, -1 if the list is empty. 
	 * 
	 * @return either the last element in the list or -1
	 */
	public int last() {
		if(count > 0) 
			return list[count - 1];
		else
			return -1; 
	}	
}
