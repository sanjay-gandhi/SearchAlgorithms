/**
 * @author Sanjay Gandhi
 * 
 *         quickselect is a selection algorithm to find the kth smallest element
 *         in an unordered list. It is related to the quicksort sorting
 *         algorithm. Like quicksort, it was developed by Tony Hoare, and thus
 *         is also known as Hoare's selection algorithm.[1] Like quicksort, it
 *         is efficient in practice and has good average-case performance, but
 *         has poor worst-case performance. Quickselect and variants is the
 *         selection algorithm most often used in efficient real-world
 *         implementations.
 * 
 *         Quickselect uses the same overall approach as quicksort, choosing one
 *         element as a pivot and partitioning the data in two based on the
 *         pivot, accordingly as less than or greater than the pivot. However,
 *         instead of recursing into both sides, as in quicksort, quickselect
 *         only recurses into one side – the side with the element it is
 *         searching for. This reduces the average complexity from O(n log n)
 *         (in quicksort) to O(n) (in quickselect).
 * 
 *         As with quicksort, quickselect is generally implemented as an
 *         in-place algorithm, and beyond selecting the kth element, it also
 *         partially sorts the data.
 * 
 *         Class Selection algorithm Data structure Array Worst case performance
 *         O(n^2) Best case performance O(n) Average case performance O(n)
 */

public class QuickSelect_Search {

	public static <T extends Comparable<T>> int search(T[] Array, T t) {
		if(Array == null)
			return -1;
		
		int index = -1;
		int start = 0;
		int end = Array.length - 1;
		while (start <= end) {
			int pivotIndex = partition(Array, start, end);
			if (Array[pivotIndex].compareTo(t) == 0) {
				index = pivotIndex;
				break;
			}
			else if(Array[pivotIndex].compareTo(t) > 0)
				end = pivotIndex-1;
			else
				start = pivotIndex+1;
		}
		return index;
	}

	public static <T extends Comparable<T>> int partition(T[] Array, int start,
			int end) {
		T pivot = Array[start];
		int i;
		for(i = 1; i < end; i++){
			if(Array[i].compareTo(pivot) > 0 ){
				swap(i, end, Array);
				end--;
			}
		}
		swap(i, start, Array);
		return i;
	}
	
	public static <T extends Comparable<T>> void swap(int index1, int index2,
			T[] Array) {
		T temp = Array[index1];
		Array[index1] = Array[index2];
		Array[index2] = temp;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Integer[] intArray = { 2, 6, 4, 1, 8, 9, 3, 5, 0, 7, 10, 5, 15 };
		String[] stringArray = { "Sanjay", "Gandhi", "Abhisek", "Vandana",
				"Pratiksha", "Monica", "Kishan", "Nirmala", "Babulal" };

		int index;
		if ((index = search(intArray, 2)) > -1)
			System.out.println("Search Result for 2 : Found !!");
		else
			System.out.println("Search Result for 2 : Not Found !! ");

		if ((index = search(intArray, 3)) > -1)
			System.out.println("Search Result for 3 : Found !!");
		else
			System.out.println("Search Result for 3 : Not Found !! ");

		if ((index = search(intArray, 15)) > -1)
			System.out.println("Search Result for 15 : Found !!");
		else
			System.out.println("Search Result for 15 : Not Found !! ");

		if ((index = search(intArray, 12)) > -1)
			System.out.println("Search Result for 12 : Found !!");
		else
			System.out.println("Search Result for 12 : Not Found !! ");
		System.out.println();

		if ((index = search(stringArray, "Sanjay")) > -1)
			System.out.println("Search Result for Sanjay : Found !!");
		else
			System.out.println("Search Result for Sanjay : Not Found !! ");

		if ((index = search(stringArray, "Vandana")) > -1)
			System.out.println("Search Result for Vandana : Found !!");
		else
			System.out.println("Search Result for Vandana : Not Found !! ");

		if ((index = search(stringArray, "Babulal")) > -1)
			System.out.println("Search Result for Babulal : Found !!");
		else
			System.out.println("Search Result for Babulal : Not Found !! ");

		if ((index = search(stringArray, "Payal")) > -1)
			System.out.println("Search Result for Payal : Found !!");
		else
			System.out.println("Search Result for Payal : Not Found !! ");
	}

}
