function solution(A) {
  // Remove duplicates and sort the list
  const A_sorted = [...new Set(A)].sort((a, b) => a - b);

  // Initialize the smallest missing positive integer
  let missing_positive = 1;

  // Iterate through the list and find the missing number
  for (const i of A_sorted) {
    if (i === missing_positive) {
      missing_positive++;
    }
  }

  return missing_positive;
}

function main() {
  while (true) {
    try {
      // Prompt the user to enter a list of numbers separated by spaces
      const userInput = prompt(
        "Enter a list of positive integers separated by spaces:"
      );
      if (!userInput) throw new Error("Input cannot be empty.");

      // Convert the user input into a list of integers
      const A = userInput.split(" ").map(Number);

      // Validate that all numbers are positive
      if (A.some((num) => num <= 0)) {
        throw new Error("All numbers must be positive integers.");
      }

      // Call the function and display the result
      const result = solution(A);
      console.log(`The smallest missing positive integer is: ${result}`);
      break; // Exit the loop if input is valid
    } catch (e) {
      console.error(`Invalid input: ${e.message}. Please try again.`);
    }
  }
}

// Execute the program
main();
