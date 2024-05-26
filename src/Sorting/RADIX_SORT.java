package Sorting;

/**
 * RADIX_SORT
 */
import java.util.Arrays;
public class RADIX_SORT {
    
    // Radix Sort for integers including negative numbers
    public void RadixSort(int[] arr) {
        // Separate negative and non-negative numbers
        int[] negativeNumbers = Arrays.stream(arr).filter(x -> x < 0).toArray();
        int[] nonNegativeNumbers = Arrays.stream(arr).filter(x -> x >= 0).toArray();
        
        // Sort negative numbers (after converting to two's complement)
        if (negativeNumbers.length > 0) {
            negativeNumbers = convertToTwosComplement(negativeNumbers);
            radixSort(negativeNumbers);
            negativeNumbers = convertFromTwosComplement(negativeNumbers);
        }
        
        // Sort non-negative numbers
        if (nonNegativeNumbers.length > 0) {
            radixSort(nonNegativeNumbers);
        }
        
        // Merge sorted arrays back together
        int index = 0;
        for (int i = 0; i < negativeNumbers.length; i++) {
            arr[index++] = negativeNumbers[i];
        }
        for (int i = 0; i < nonNegativeNumbers.length; i++) {
            arr[index++] = nonNegativeNumbers[i];
        }
    }
    
    // Radix Sort implementation for non-negative integers
    private void radixSort(int[] arr) {
        // Find maximum element to determine number of digits
        int max = getMax(arr);
        
        // Perform counting sort for each digit (from least significant to most significant)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }
    
    // Counting sort implementation
    private void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // Count array to store count of occurrences of digits (0-9)
        
        // Initialize count array
        Arrays.fill(count, 0);
        
        // Store count of occurrences in count[] array
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        
        // Modify count array to store actual position of digits in output[] array
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        // Copy output array to original array
        System.arraycopy(output, 0, arr, 0, n);
    }
    
    // Helper method to find the maximum element in the array
    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    
    // Helper method to convert array of negative numbers to two's complement
    private int[] convertToTwosComplement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ~arr[i] + 1; // Flip bits and add 1
        }
        return arr;
    }
    
    // Helper method to convert array of negative numbers from two's complement
    private int[] convertFromTwosComplement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ~arr[i] + 1; // Flip bits and add 1
        }
        return arr;
    }
    
    // Helper method to print an array
    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}