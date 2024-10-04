import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class SmallestMissingPositive {
    public static int solution(int[] A) {
        // Remove duplicates and sort the list
        HashSet<Integer> set = new HashSet<>();
        for (int num : A) {
            set.add(num);
        }
        Integer[] A_sorted = set.toArray(new Integer[0]);
        Arrays.sort(A_sorted);

        // Initialize the smallest missing positive integer
        int missing_positive = 1;

        // Iterate through the list and find the missing number
        for (int i : A_sorted) {
            if (i == missing_positive) {
                missing_positive++;
            }
        }

        return missing_positive;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                // Prompt the user to enter a list of numbers separated by spaces
                System.out.print("Enter a list of positive integers separated by spaces: ");
                String userInput = scanner.nextLine();

                // Convert the user input into a list of integers
                String[] inputStrings = userInput.split(" ");
                int[] A = Arrays.stream(inputStrings).mapToInt(Integer::parseInt).toArray();

                // Validate that all numbers are positive
                for (int num : A) {
                    if (num <= 0) {
                        throw new IllegalArgumentException("All numbers must be positive integers.");
                    }
                }

                // Call the function and display the result
                int result = solution(A);
                System.out.println("The smallest missing positive integer is: " + result);
                break; // Exit the loop if input is valid

            } catch (Exception e) {
                System.out.println("Invalid input: " + e.getMessage() + ". Please try again.");
            }
        }
        scanner.close();
    }
}
