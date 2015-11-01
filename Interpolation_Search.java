/**
 * @author Sanjay Gandhi
 * 
 *         Interpolation search (sometimes referred to as extrapolation search)
 *         is an algorithm for searching for a given key value in an indexed
 *         array that has been ordered by the values of the key. It parallels
 *         how humans search through a telephone book for a particular name, the
 *         key value by which the book's entries are ordered. In each search
 *         step it calculates where in the remaining search space the sought
 *         item might be, based on the key values at the bounds of the search
 *         space and the value of the sought key, usually via a linear
 *         interpolation.
 * 
 *         On average the interpolation search makes about log(log(n))
 *         comparisons (if the elements are uniformly distributed), where n is
 *         the number of elements to be searched. In the worst case (for
 *         instance where the numerical values of the keys increase
 *         exponentially) it can make up to O(n) comparisons.
 *
 */

public class Interpolation_Search {

	public static int search(Integer[] Array, int t) {
		if (Array == null)
			return -1;
		int index = -1;
		int start = 0;
		int end = Array.length - 1;
		while (start < end) {
			int mid = start + (end - start)
					* ((t - Array[start]) / (Array[end] - Array[start]));
			if (Array[mid] == t) {
				index = mid;
				break;
			} else if (Array[mid] > t)
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

	public static <T extends Comparable<T>> void mergeSort(T[] Array, T[] temp,
			int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(Array, temp, left, center);
			mergeSort(Array, temp, center + 1, right);
			merge(Array, temp, left, center, right);
		}
	}

	public static <T extends Comparable<T>> void merge(T[] Array, T[] temp,
			int left, int center, int right) {

		for (int i = left; i <= right; i++)
			temp[i] = Array[i];

		int i = left;
		int j = center + 1;

		for (int k = left; k <= right; k++) {
			if ((j > right)
					|| ((i <= center) && (temp[i].compareTo(temp[j]) <= 0)))
				Array[k] = temp[i++];
			else
				Array[k] = temp[j++];
		}
	}

	public static void main(String[] args) {

		Integer[] intArray = { 2, 6, 4, 1, 8, 9, 3, 5, 0, 7, 10, 5, 15 };

		sort(intArray);
		for (int i : intArray)
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

	}
}
