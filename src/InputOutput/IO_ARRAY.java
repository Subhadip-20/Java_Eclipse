package InputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO_ARRAY {

    // Method to display the elements of an array
    public void DisplayArray(int arr[]) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length - 1] + "]");
    }

    // Method to take user input and create an array
    public int[] InputArray() {
        int arr[], size;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                // Prompt user to enter the size of the array
                do {
                    System.out.print("Enter the size of the array (must be greater than 0): ");
                    size = Integer.parseInt(br.readLine());
                } while (size <= 0); // Ensure size is greater than 0
                
                arr = new int[size];

                // Loop to take user input for each element of the array
                for (int i = 0; i < arr.length; i++) {
                    while (true) {
                        try {
                            System.out.print("Enter element number " + (i + 1) + " : ");
                            arr[i] = Integer.parseInt(br.readLine());
                            break; // Break out of the loop if input is valid
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid input. Please enter an integer.");
                        }
                    }
                }

                // If no exception is thrown, break out of the loop
                break;
            } catch (IOException | NumberFormatException e) {
                // Handle incorrect input gracefully
                System.out.println("Error: Invalid input. Please enter an integer.");
            }
        }


        // Close the BufferedReader
//        try {
//            br.close();
//        } catch (IOException e) {
//            System.out.println("Error while closing BufferedReader: " + e.getMessage());
//        }

        // Return the created array
        return arr;
    }
}
