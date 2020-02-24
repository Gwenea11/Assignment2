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
		if(count == 0) {
			list[0] = newInt; 
			count++; 
		}
		else if (count > 0 && count < 10) {	//when the list isn't full
			for (int index = (count - 1); index >= 0; index--) {
				list[index + 1] = list[index];	//set the next element to the previous element 				
			}
			list[0] = newInt; 
			count++;
		}
		else {	//when the list is full 
			for(int index = 9; index > 0; index--) {
				list[index] = list[index - 1]; 
				list[0] = newInt; 
			}
		}
	}
	
	
	
	/**
	 * Removes all occurrences of an element from the list, will shift all following elements left if the element
	 * exists. If it doesn't exist, the array will be unchanged.  
	 * 
	 * @param key the element to be removed if it exists 
	 */
	public void remove(int key) {
		int locale = search(key);	//index for element to be removed
		
		while(locale != -1) {
			if(locale == 9) {	//when element is the last element of the array 
				count--;	
		    }
			else {
				for(int index = locale; index < (count - 1); index++) 
					list[index] = list[index + 1];
				
				count--; 
			}
			
			locale = search(key); 
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
		for(int index = 0; index < (count - 1); index++) {
			if (list[index] == key) {
				location = index;
				index += 10; 		//break to return the first occurrence of key
			}
		}
		return location; 
	}
}
