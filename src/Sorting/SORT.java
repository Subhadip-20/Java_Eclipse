package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.Scanner;

import InputOutput.IO_ARRAY;

public class SORT {
    static IO_ARRAY ia = new IO_ARRAY();

    public static void main(String[] args) throws IOException {
    	
    	boolean runAgain = true;
    	 Scanner scanner = new Scanner(System.in);
        while (runAgain) {

        // Take input for the array
        int[] arr = ia.InputArray();

        // Display the original array
        System.out.print("Original Array: ");
        ia.DisplayArray(arr);

        // Ask the user to choose a sorting option
       
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose a sorting option:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Quick Sort");
        System.out.println("5. Merge Sort");
        System.out.println("6. Heap Sort");
        System.out.println("7. Radix Sort");
        System.out.println("8. Shell Sort");
        System.out.println("9. Compare all sorting techniques");

        int choice =Integer.parseInt(br.readLine());

        switch (choice) {
            case 1:
                bubbleSort(arr.clone());
                break;
            case 2:
                selectionSort(arr.clone());
                break;
            case 3:
                insertionSort(arr.clone());
                break;
            case 4:
                quickSort(arr.clone(), 0, arr.length - 1);
                break;
            case 5:
                mergeSort(arr.clone(), 0, arr.length - 1);
                break;
            case 6:
                heapSort(arr.clone());
                break;
            case 7:
                radixSort(arr.clone());
                break;
            case 8:
                shellSort(arr.clone());
                break;
            case 9:
                compareAllSortingTechniques(arr.clone());
                break;
            default:
                System.out.println("Invalid choice. No sorting performed.");
                break;
        }
        System.out.println("Do you want to run the program again? (yes/no)");
        String input = br.readLine().toLowerCase();
        runAgain = input.equals("yes");
       
    }
        scanner.close();
    }

    public static void bubbleSort(int[] arr) {
        long startTime = System.nanoTime();
        BUBBLE_SORT bs = new BUBBLE_SORT();
        arr = bs.BubbleSort(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) ; // Convert to nanoseconds
        System.out.println("Time taken for Bubble Sort: " + duration + " nanoseconds");
        System.out.print("Sorted Array: ");
        ia.DisplayArray(arr);
    }

    public static void selectionSort(int[] arr) {
        long startTime = System.nanoTime();
        SELECTION_SORT ss = new SELECTION_SORT();
        arr = ss.SelectionSort(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) ; // Convert to nanoseconds
        System.out.println("Time taken for Selection Sort: " + duration + " nanoseconds");
        System.out.print("Sorted Array: ");
        ia.DisplayArray(arr);
    }

    public static void insertionSort(int[] arr) {
        long startTime = System.nanoTime();
        INSERTION_SORT is = new INSERTION_SORT();
        arr = is.InsertionSort(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) ; // Convert to nanoseconds
        System.out.println("Time taken for Insertion Sort: " + duration + " nanoseconds");
        System.out.print("Sorted Array: ");
        ia.DisplayArray(arr);
    }

    public static void quickSort(int[] arr, int low, int high) {
        long startTime = System.nanoTime();
        QUICK_SORT qs = new QUICK_SORT();
        qs.QuickSort(arr, low, high);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) ; // Convert to nanoseconds
        System.out.println("Time taken for Quick Sort: " + duration + " nanoseconds");
        System.out.print("Sorted Array: ");
        ia.DisplayArray(arr);
    }

    public static void mergeSort(int[] arr, int low, int high) {
        long startTime = System.nanoTime();
        MERGE_SORT ms = new MERGE_SORT();
        ms.MergeSort(arr, low, high);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) ; // Convert to nanoseconds
        System.out.println("Time taken for Merge Sort: " + duration + " nanoseconds");
        System.out.print("Sorted Array: ");
        ia.DisplayArray(arr);
    }

    public static void heapSort(int[] arr) {
        long startTime = System.nanoTime();
        HEAP_SORT hs = new HEAP_SORT();
        hs.HeapSort(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) ; // Convert to nanoseconds
        System.out.println("Time taken for Heap Sort: " + duration + " nanoseconds");
        System.out.print("Sorted Array: ");
        ia.DisplayArray(arr);
    }

    public static void radixSort(int[] arr) {
        long startTime = System.nanoTime();
        RADIX_SORT rs = new RADIX_SORT();
        rs.RadixSort(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) ; // Convert to nanoseconds
        System.out.println("Time taken for Radix Sort: " + duration + " nanoseconds");
        System.out.print("Sorted Array: ");
        ia.DisplayArray(arr);
    }

    public static void shellSort(int[] arr) {
        long startTime = System.nanoTime();
        SHELL_SORT shs = new SHELL_SORT();
        shs.ShellSort(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) ; // Convert to nanoseconds
        System.out.println("Time taken for Shell Sort: " + duration + " nanoseconds");
        System.out.print("Sorted Array: ");
        ia.DisplayArray(arr);
    }

    public static void compareAllSortingTechniques(int[] arr) {
        System.out.println("Comparing all sorting techniques:\n");
        bubbleSort(arr.clone());
        selectionSort(arr.clone());
        insertionSort(arr.clone());
        quickSort(arr.clone(), 0, arr.length - 1);
        mergeSort(arr.clone(), 0, arr.length - 1);
        heapSort(arr.clone());
        radixSort(arr.clone());
        shellSort(arr.clone());
    }
}