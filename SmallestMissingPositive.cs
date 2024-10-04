using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static int Solution(int[] A)
    {
        // Remove duplicates and sort the list
        var A_sorted = new HashSet<int>(A).ToList();
        A_sorted.Sort();

        // Initialize the smallest missing positive integer
        int missing_positive = 1;

        // Iterate through the list and find the missing number
        foreach (var i in A_sorted)
        {
            if (i == missing_positive)
            {
                missing_positive++;
            }
        }

        return missing_positive;
    }

    static void Main(string[] args)
    {
        while (true)
        {
            try
            {
                // Prompt the user to enter a list of numbers separated by spaces
                Console.Write("Enter a list of positive integers separated by spaces: ");
                var userInput = Console.ReadLine();
                if (string.IsNullOrWhiteSpace(userInput)) throw new ArgumentException("Input cannot be empty.");

                // Convert the user input into a list of integers
                var A = userInput.Split(' ').Select(int.Parse).ToArray();

                // Validate that all numbers are positive
                if (A.Any(num => num <= 0))
                {
                    throw new ArgumentException("All numbers must be positive integers.");
                }

                // Call the function and display the result
                var result = Solution(A);
                Console.WriteLine($"The smallest missing positive integer is: {result}");
                break; // Exit the loop if input is valid
            }
            catch (Exception e)
            {
                Console.WriteLine($"Invalid input: {e.Message}. Please try again.");
            }
        }
    }
}
