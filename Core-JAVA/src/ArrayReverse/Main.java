package ArrayReverse;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random randObj = new Random(); // Random object for creating random integers.
        int[] arr1 = new int[3]; // Creating array of 3 size.

        // Filling the array with random numbers.
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = randObj.nextInt(100);
        }

        // Printing array's elements before and after reversal.
        System.out.println("Original array: " + Arrays.toString(arr1));

        int[] arr2 = reverser(arr1); // Reversing array.

        System.out.println("Reversed array: " + Arrays.toString(arr2));
    }

    // This function will take an input array, and it will return the
    // reversed version of the input array as a new array (not in-place).
    public static int[] reverser(int[] inputArray) {

        // Creating an array to return that will have the same size as the input array.
        int lengthCounter = inputArray.length;
        int[] outputArray = new int[lengthCounter];

        // Reverse operation.
        for (int j : inputArray) {
            outputArray[lengthCounter - 1] = j;
            lengthCounter = lengthCounter - 1;
        }
        return outputArray;
    }
}