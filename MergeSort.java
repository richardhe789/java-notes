import java.util.Arrays;
import java.lang.Math;

public class MergeSort {
	public static void main(String[] args) {
		int[] numbers = {98, 62, 62, 22, 35, 17, 62, 86, 77, 6};
		System.out.print("Original list:");
		for(int item : numbers) 
			System.out.print(" " + item);
		System.out.println("");

		mergeSort(numbers, 0, numbers.length - 1);

		System.out.print("\nSorted list:");
		for(int item : numbers) 
			System.out.print(" " + item);	

	}

	public static void mergeSort(int[] array, int left, int right) {
		if  (left < right)  {
			int mid =   (left + right) / 2  ;

			System.out.print("\nSplitting:");
			System.out.print("\nLeft:");
			for (int ii=left; ii<=mid; ii++) {System.out.print(" " + array[ii]);}
			System.out.print("\nRight:");
			for (int ii=mid + 1; ii<=right; ii++) {System.out.print(" " + array[ii]);}			
			System.out.println("\n");

			mergeSort(array, left, mid);

			mergeSort(array, mid + 1, right);

			merge(array, left, mid, right);
		}
	}

	public static void merge(int[] array, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];

		for (int i = 0; i < n1; i++) {
			leftArray[i] = array[left + i];
		}
		for (int j = 0; j < n2; j++) {
			rightArray[j] = array[mid + 1 + j];
		}

		System.out.print("\nMerging:");
		System.out.print("\nLeft:");		
		for (int ii=left; ii<=mid; ii++) {System.out.print(" " + array[ii]);}
		System.out.print("\nRight:");
		for (int ii=mid+1; ii<=right; ii++) {System.out.print(" " + array[ii]);}

		int i = 0, j = 0;
		int k = left;

		while (i < n1 && j < n2) {
			if (leftArray[i] <= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			array[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < n2) {
			array[k] = rightArray[j];
			j++;
			k++;
		}

		int[] someArray = Arrays.copyOfRange(array, left, right+1);

		System.out.print("\nMerged:");

		for(int item1 : someArray) 
			System.out.print(" " + item1);	
		System.out.println("");

	}

}
