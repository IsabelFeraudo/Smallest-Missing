def solution(A):
    # Remove duplicates and sort the list
    A_sorted = sorted(set(A))
    
    # Initialize the smallest missing positive integer
    missing_positive = 1
    
    # Iterate through the list and find the missing number
    for i in A_sorted:
        if i == missing_positive:
            missing_positive += 1
    
    return missing_positive

def main():
    while True:
        try:
            # Prompt the user to enter a list of numbers separated by spaces
            user_input = input("Enter a list of positive integers separated by spaces: ")
            
            # Convert the user input into a list of integers
            A = list(map(int, user_input.split()))
            
            # Validate that all numbers are positive
            if any(num <= 0 for num in A):
                raise ValueError("All numbers must be positive integers.")
            
            # Call the function and display the result
            result = solution(A)
            print(f"The smallest missing positive integer is: {result}")
            break  # Exit the loop if input is valid
            
        except ValueError as e:
            print(f"Invalid input: {e}. Please try again.")

# Execute the program
if __name__ == "__main__":
    main()
