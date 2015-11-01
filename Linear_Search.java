/**
 * @author Sanjay Gandhi
 * 
 *         Linear search is the simplest search algorithm; it is a special case
 *         of brute-force search. Its worst case cost is proportional to the
 *         number of elements in the list. Its expected cost is also
 *         proportional to the number of elements if all elements are searched
 *         equally.
 *
 */
public class Linear_Search {

	public static <T extends Comparable<T>> int search(T[] Array, T t) {
		if(Array == null)
			return -1;
		
		int index = -1;
		for(int i = 0; i < Array.length; i++){
			if(Array[i].compareTo(t) == 0){
				index = i;
				break;
			}
		}
		return index;
	}

	public static void main(String[] args) {

		Integer[] intArray = { 2, 6, 4, 1, 8, 9, 3, 5, 0, 7, 10, 5, 15 };
		String[] stringArray = { "Sanjay", "Gandhi", "Abhisek", "Vandana",
				"Pratiksha", "Monica", "Kishan", "Nirmala", "Babulal" };

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
