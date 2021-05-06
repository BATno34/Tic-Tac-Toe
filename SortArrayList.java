package Apr20;

import java.util.ArrayList;
import java.util.*;
	/**
	 * Purpose: To look at different sorting algorithms
	 * @author Ardavan Alaei Fard
	 * @Revised version April 2021
	 */

	public class SortArrayList {
		/**
		 * Generates a random String of characters of the given length
		 * @param length the length of the string
		 * @return the randomly generated String
		 */
		static String randomString(int length)
		{
			char[] charString = new char[length];
			for (int i = 0; i < length; i++)
				charString[i] = (char) ('A' + Math.random() * 26);
			return new String(charString);
		}

		/**
		 * Generates an ArrayList of random Strings of length 5
		 * @param noOfElements the size of the ArrayList to generate
		 * @return the new ArrayList
		 */
		private static ArrayList<String> generateArrayList(int noOfElements)
		{
			ArrayList<String> list = new ArrayList<String>(noOfElements);
			for (int i = 0; i < noOfElements; i++)
				list.add(randomString(5));
			return list;
		}

		/**
		 * Displays the elements of an List of Strings in nice columns
		 * @param list the list to display
		 */
		private static void displayList(ArrayList<String> list)
		{
			int colCount = 0;
			for (String next : list)
			{
				System.out.printf("%8s", next);
				colCount++;
				if (colCount == 10)
				{
					System.out.println();
					colCount = 0;
				}
			}
			System.out.println();
		}
		
		

		/**
		 * Sorts a List in ascending order (lowest to highest) using the bubble sort
		 * algorithm
		 * @param list the List to sort
		 */
		private static void bubbleSort(ArrayList<String> list)
		{
			int swaps;
			String copy;
			int turn = 0;
			do {
				swaps = 0;
				for (int i = 0; i < (list.size() - turn - 1); i++) {
					if (list.get(i).compareTo(list.get(i + 1)) > 0) {
						copy = list.remove(i + 1);     //remove and save the word
						list.add(i, copy);     //add the removed word behind
						swaps++;     //counting swaps
					}
				}
				turn++;
			} while (swaps != 0);     //when there was no swap, it means that it's sorted
		}

		/**
		 * Sorts a List in ascending order (lowest to highest) using the selection
		 * sort algorithm
		 * @param list the List to sort
		 */
		private static void selectionSort(ArrayList<String> list)
		{
			int size = list.size();
			String copy;
			for (int i = 0; i < size; i++) {
				int removeIndex = i;
				for (int m = i + 1; m < size; m++) {
					if (list.get(m).compareTo(list.get(removeIndex)) < 0) {
						removeIndex = m;     //find the index of the minimum element
					}
				}
				copy = list.remove(removeIndex);     //removing the minimum element
				list.add(i, copy);     //adding the removed word to the beginning of list
			}
		}
		
		
		/**
		 * Sorts a List in ascending order (lowest to highest) using the insertion
		 * sort algorithm
		 * @param list the List to sort
		 */
		private static void insertionSort(ArrayList<String> list)
		{
			int size = list.size();
			for (int m = 1; m < size; m++) {
				String startingPoint = list.get(m);
				int i = m - 1;
				
				while(i >= 0 && list.get(i).compareTo(startingPoint) > 0) {
					list.set((i+1), list.get(i));     //bringing the words to the left one by one
					i--;
				}
				
				list.set((i+1), startingPoint);    //setting new position of the checking word
				
			}
		}

		/**
		 * Sorts an List in ascending order (lowest to highest) using the merge sort
		 * algorithm. 		 * 
		 * @param list the List to sort
		 */
		private static void mergeSort(ArrayList<String> list)
		{
			
			if (list.size() >= 2) 
			{
			int middle = (list.size() / 2);
				
			ArrayList<String> leftSide = new ArrayList<String>();
			ArrayList<String> rightSide = new ArrayList<String>();
				
			for (int i = 0; i < middle; i++)     
				leftSide.add(list.get(i));     //setting the list of left side
			for (int m = middle; m < list.size(); m++)
				rightSide.add(list.get(m));     //setting the list of right side
			
			//recursion to make sure all list is separated
			mergeSort(leftSide);
			mergeSort(rightSide);
				
			int l = 0; int r = 0; int m = 0;
			
			//merging the list
			while (l < (middle) && r < (list.size() - middle)) {
				if (rightSide.get(r).compareTo(leftSide.get(l)) <= 0) {
					list.set(m, rightSide.get(r));     //adding the one on right list if it comes first alphabetically
					r++;
				}
				else {
					list.set(m, leftSide.get(l));     //adding the one on left list if it comes first alphabetically
					l++;
				}
				m++;
			}
				
			while (r < (list.size() - middle)) {
				list.set(m, rightSide.get(r));     //adding the rest of the right side list
				m++;
				r++;
				print(hello);
			}
				
			while (l < middle) {
				list.set(m, leftSide.get(l));     //adding the rest of the left side list
				m++;
				l++;
			}
			}
		}
		
		/**
		 * Sorts a List in ascending order (lowest to highest) using the quick
		 * sort algorithm
		 * @param start the starting index
		 * @param finish the last index
		 * @param list the List to sort
		 */
		private static void quickSort(int start, int finish, ArrayList<String> list)
		{
			String swapCopy;
			if (start < finish) {
				String pivot = list.get(finish);     //setting the last word as pivot
				int m = start - 1;
				
				//swapping words if they come before the pivot alphabetically
				for (int i = start; i < finish; i++) {
					if (list.get(i).compareTo(pivot) <= 0) {
						m++;
						swapCopy = list.get(m);
						list.set(m, list.get(i));
						list.set(i, swapCopy);
					}
				}
				
				//swapping last word to bring it to the correct position
				swapCopy = list.get(m+1);
				list.set((m+1), list.get(finish));
				list.set(finish, swapCopy);
				
				//recursion to bring all words to their correct positions
				quickSort(start, m, list);
				quickSort(m+2, finish, list);
			}
		}
		
		
		/**
		 * Finding a word (target) using the binary searching 
		 * sort algorithm
		 * @param start, the beginning index of the list to check
		 * @param finish, the last index of the list to check
		 * @param list the List to sort
		 * @param target, the word we're looking for
		 */
		private static int binarySearching (int start, int finish, ArrayList<String> list, String target)
		{

			if (finish >= start)
			{
			int middle = (start + finish) / 2;
			String check = list.get(middle);     //setting the middle word to check
			if (check.compareTo(target) < 0)
				return binarySearching(middle + 1, finish, list, target);     //check the upper half of the list using recursion
			else if (check.compareTo(target) > 0)
				return binarySearching(start, middle - 1, list, target);     //check the lower half of the list using recursion
			else
				return middle;
			}
			
			return -1;     //return -1 if the word was not found
			
		}
		
		
		
		/**
		 * Checks if the given List is sorted in ascending order
		 * 
		 * @param list the List to check to see if it is in order
		 * @param listInOrder the List in order
		 * @return true if the list is sorted in ascending order, false otherwise
		 */
		public static boolean isSorted(ArrayList<String> list, ArrayList<String> listInOrder)
		{
			// Check if something is out of order
			for (int i = 0; i < list.size(); i++)
				if (list.get(i).compareTo(listInOrder.get(i)) != 0)
					return false;

			// Everything was in order
			return true;
		}
		
	   /**
	    * Finding the time for each sorting method	
	    * @param list the List to check
	    * @param sizeToCheck size of the List
	    * @param sortingMethod the method we use for sorting
	    * @param typeOfList the type of list that we want to check (ie. random, sorted, reverse)
	    */
		public static void findTime(ArrayList<String> list, int sizeToCheck, String sortingMethod, String typeOfList) {
			
			long startTime = 0;
			long endTime = 0;
			
			list = generateArrayList(sizeToCheck);     //generating list
			if (typeOfList.equals("sorted"))
				Collections.sort(list);
			else if (typeOfList.equals("reverse")) {
				Collections.sort(list);
				Collections.reverse(list);
			}
			
			//timing for each method of sorting
			if (sortingMethod.equals("bubble sort")) {
				startTime = System.nanoTime();     //starting the timer
				bubbleSort(list);     //calling the method to sort the list
				endTime = System.nanoTime();     //ending the timer
			}
			else if (sortingMethod.equals("selection sort")) {
				startTime = System.nanoTime();
				selectionSort(list);
				endTime = System.nanoTime();
			}
			else if (sortingMethod.equals("insertion sort")) {
				startTime = System.nanoTime();
				insertionSort(list);
				endTime = System.nanoTime();
			}
			else if (sortingMethod.equals("quick sort")) {
				startTime = System.nanoTime();
				quickSort(0, (list.size() - 1), list);
				endTime = System.nanoTime();
			}
			else if (sortingMethod.equals("merge sort")) {
				startTime = System.nanoTime();
				mergeSort(list);
				endTime = System.nanoTime();
			}
			
			//printing out the result
			System.out.printf("Total time to sort %,d %s elements using i.e: %s: ", sizeToCheck, typeOfList, sortingMethod);
			double time = (endTime - startTime) / 1000000.0;
			System.out.printf("%,.0f ms%n", time);
			if (typeOfList.equals("reverse"))
				System.out.println();
		}

		public static void main(String[] args)
		{
			final int LIST_SIZE = 50;
			System.out.println("Sorting an Array of Strings of LIST_SIZE = " + LIST_SIZE);

			// You may want to comment out some of this codes as you work through
			// the assignment

			// Generate an ArrayList and display the initial array
			ArrayList<String> list = generateArrayList(LIST_SIZE);
			
			System.out.println("Here is the original list: ");
			displayList(list);

			// Make a copy of this list and then sort it for later comparison in
			// isSorted
			ArrayList<String> listInOrder = new ArrayList<String>(list);
			Collections.sort(listInOrder);

		
			// Sort the ArrayList using different sorts
			bubbleSort(list);
			// Display the sorted list
			System.out.println("\nHere is the sorted list for bubble sort: ");
			displayList(list);
			if (isSorted(list, listInOrder))
				System.out.println("Bubble sort works");
			else
				System.out.println("Bubble sort doesn't work");

			// Mix up the list for the next sort
			Collections.shuffle(list);
			selectionSort(list);
			// Display the sorted list
			System.out.println("\nHere is the sorted list for selection sort: ");
			displayList(list);
			if (isSorted(list, listInOrder))
				System.out.println("Selection sort works");
			else
				System.out.println("Selection sort doesn't work");

			// Mix up the list for the next sort
			Collections.shuffle(list);
			insertionSort(list);
			// Display the sorted list
			System.out.println("\nHere is the sorted list for insertion sort: ");
			displayList(list);
			if (isSorted(list, listInOrder))
				System.out.println("Insertion sort works");
			else
				System.out.println("Insertion sort doesn't work");
			
			// Mix up the list for the next sort
			Collections.shuffle(list);
			quickSort(0, (list.size() - 1), list);
			// Display the sorted list
			System.out.println("\nHere is the sorted list for quick sort: ");
			displayList(list);
			if (isSorted(list, listInOrder))
				System.out.println("Quick sort works");
			else
				System.out.println("Quick sort doesn't work");

			// Mix up the list for the next sort
			Collections.shuffle(list);
			mergeSort(list);
			// Display the sorted list
			System.out.println("\nHere is the sorted list for merge sort: ");
			displayList(list);
			if (isSorted(list, listInOrder))
				System.out.println("Merge sort works");
			else
				System.out.println("Merge sort doesn't work");
			
			// Binary searching for the word 'MOUSE'
			System.out.println("\nHere is the list for binary searching (looking for 'MOUSE'): ");
			ArrayList<String> searchArray = generateArrayList(49);
			searchArray.add("MOUSE");
			Collections.sort(searchArray);
			displayList(searchArray);
			int index = binarySearching(0, 49, searchArray, "MOUSE");
			if (index != -1)
				System.out.println("The word 'MOUSE' is at index " + index);
			else
				System.out.println("The word 'MOUSE' was not found.");     //since we have added the word 'MOUSE', it won't happen
			
			System.out.println("\nTiming each of the sorts using different LIST_SIZE...\n");
			
			// Compare the run times of each sort for different ordered lists
			// Change the type of sort to test each sort
			// Calling the methods to find the time
			
			for (int i = 1; i < 5; i++) {
				if (i < 3) {
					findTime(list, (i*10000), "merge sort", "random");
					findTime(list, (i*10000), "merge sort", "sorted");
					findTime(list, (i*10000), "merge sort", "reverse");
				}
				else if (i == 3) {
					findTime(list, (100000), "merge sort", "random");
					findTime(list, (100000), "merge sort", "sorted");
					findTime(list, (100000), "merge sort", "reverse");
				}
				else {
					findTime(list, (1000000), "merge sort", "random");
					findTime(list, (1000000), "merge sort", "sorted");
					findTime(list, (1000000), "merge sort", "reverse");
				}
			}
			
			for (int i = 1; i < 3; i++) {
				findTime(list, (i*10000), "bubble sort", "random");
				findTime(list, (i*10000), "bubble sort", "sorted");
				findTime(list, (i*10000), "bubble sort", "reverse");
				
				findTime(list, (i*10000), "selection sort", "random");
				findTime(list, (i*10000), "selection sort", "sorted");
				findTime(list, (i*10000), "selection sort", "reverse");
				
				findTime(list, (i*10000), "insertion sort", "random");
				findTime(list, (i*10000), "insertion sort", "sorted");
				findTime(list, (i*10000), "insertion sort", "reverse");
				
				findTime(list, (i*10000), "quick sort", "random");
				findTime(list, (i*10000), "quick sort", "sorted");
				findTime(list, (i*10000), "quick sort", "reverse");
			}

			System.out.println("Program is Complete");
			
		} // main method
	} // Sorting class
