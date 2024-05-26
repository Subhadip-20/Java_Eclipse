package Sorting;

/**
 * INSERTION_SORT
 */
public class INSERTION_SORT {

    public int[] InsertionSort(int arr[]){
    	
    	// Loop through each element in the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Store the current element to be compared
            int key = arr[i];
            // Initialize the previous element index
            int j = i - 1;

            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            // Place the key element at its correct position
            arr[j + 1] = key;
        }
        return arr;
    }
}