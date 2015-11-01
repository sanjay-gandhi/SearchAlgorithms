/**
 * @author Sanjay Gandhi
 * 
 *         a binary search or half-interval search algorithm finds the position
 *         of a specified input value (the search "key") within an array sorted
 *         by key value.
 * 
 *         Class Search algorithm Data structure Array Worst case performance
 *         O(log n) Best case performance O(1) Average case performance O(log n)
 *         Worst case space complexity O(1)
 *
 */

public class Binary_Search {
	
	public static <T extends Comparable<T>> int search(T[] Array, T t){	
		if(Array == null)
			return -1;
		
		int index = -1;
		int start = 0;
		int end = Array.length-1;
		while(start <= end){
			int mid = (start + end) / 2;
			if(Array[mid].compareTo(t) == 0)
				return mid;
			else if(Array[mid].compareTo(t) > 0)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return index;
	}

	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void sort(T[] Array) {
		T[] temp = (T[]) new Comparable[Array.length];
		mergeSort(Array, temp, 0, Array.length - 1);
		
	}

	public static <T extends Comparable<T>> void mergeSort(T[] Array, T[] temp, int left,
			int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(Array, temp, left, center);
			mergeSort(Array, temp, center + 1, right);
			merge(Array, temp, left, center, right);
		}
	}

	public static <T extends Comparable<T>> void merge(T[] Array, T[] temp, int left,
			int center, int right) {

		for (int i = left; i <= right; i++)
			temp[i] = Array[i];
		
		int i = left;
		int j = center + 1;

		for (int k = left; k <= right; k++) {
			if( (j > right) || ( (i <= center) && (temp[i].compareTo(temp[j]) <= 0) ) )
				Array[k] = temp[i++];
			else
				Array[k] = temp[j++];
		}
	}

	public static void main(String[] args) {	

		Integer[] intArray = { 2, 6, 4, 1, 8, 9, 3, 5, 0, 7, 10, 5, 15 };
		String[] stringArray = { "Sanjay", "Gandhi", "Abhisek", "Vandana",
				"Pratiksha", "Monica", "Kishan", "Nirmala", "Babulal" };
		
		sort(intArray);
		for(int i : intArray)
			System.out.print(i + " ");
		System.out.println();
		

		int index;
		if ((index = search(intArray, 2)) > -1)
			System.out.println("Search Result for 2 : " + index);
		else
			System.out.println("Search Result for 2 : Not Found !! ");
		
		if ((index = search(intArray, 3)) > -1)
			System.out.println("Search Result for 3 : " + index);
		else
			System.out.println("Search Result for 3 : Not Found !! ");
		
		if ((index = search(intArray, 15)) > -1)
			System.out.println("Search Result for 15 : " + index);
		else
			System.out.println("Search Result for 15 : Not Found !! ");
		
		if ((index = search(intArray, 12)) > -1)
			System.out.println("Search Result for 12 : " + index);
		else
			System.out.println("Search Result for 12 : Not Found !! ");
		System.out.println();
		
		sort(stringArray);
		for(String i : stringArray)
			System.out.print(i + " ");
		System.out.println();
		
		if ((index = search(stringArray, "Sanjay")) > -1)
			System.out.println("Search Result for Sanjay : " + index);
		else
			System.out.println("Search Result for Sanjay : Not Found !! ");
		
		if ((index = search(stringArray, "Vandana")) > -1)
			System.out.println("Search Result for Vandana : " + index);
		else
			System.out.println("Search Result for Vandana : Not Found !! ");
		
		if ((index = search(stringArray, "Babulal")) > -1)
			System.out.println("Search Result for Babulal : " + index);
		else
			System.out.println("Search Result for Babulal : Not Found !! ");
		
		if ((index = search(stringArray, "Payal")) > -1)
			System.out.println("Search Result for Payal : " + index);
		else
			System.out.println("Search Result for Payal : Not Found !! ");

	}
}
