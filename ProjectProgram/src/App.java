/**
 * Purpose:
 * - This program collects quiz grades from the user and processes them.
 *
 * Requirements (Assignment Specs):
 * 1) Create a Java project and write a method to print the program specifications.
 * 2) Read quiz grades from the keyboard (console input).
 *    - Allow entering up to 10 grades.
 *    - Grade range is 0 to 100.
 *    - Enter 999 to stop entering grades early.
 * 3) Store valid grades in an array.
 *    - Keep track of the total and the number of grades entered.
 * 4) Display all grades entered (use a loop to print them).
 * 5) Compute and display the average quiz grade.
 * 6) Determine and display the letter grade based on the average:
 *    - A = 90–100
 *    - B = 80–89
 *    - C = 70–79
 *    - D = 60–69
 *    - F = 0–59
 *
 * Notes:
 * - Input validation should reject values outside 0–100 (except 999).
 */

import java.util.Scanner;

public class App {

    /**
     * Prints the program specifications (requirements).
     * This method is required by the assignment as the first step.
     */
    public static void printProgramSpecs() {
        System.out.println("======================================");
        System.out.println("Project Program - Quiz Grades");
        System.out.println("Enter up to 10 quiz grades (0-100).");
        System.out.println("Type 999 to stop entering grades.");
        System.out.println("The program will display all grades,");
        System.out.println("calculate the average, and show letter grade.");
        System.out.println("======================================\n");
    }

    /**
     * Converts the average quiz score to a letter grade based on the rubric:
     * A = 90-100, B = 80-89, C = 70-79, D = 60-69, F = 0-59
     *
     * @param avg the average score
     * @return the corresponding letter grade (A-F)
     */
    public static char getLetterGrade(double avg) {
        if (avg >= 90) return 'A';
        if (avg >= 80) return 'B';
        if (avg >= 70) return 'C';
        if (avg >= 60) return 'D';
        return 'F';
    }

    public static void main(String[] args) {

        // Step 1: Display the program specifications.
        printProgramSpecs();

        Scanner sc = new Scanner(System.in);

        // Store up to 10 quiz grades in an array (as required).
        int[] grades = new int[10];

        // count = number of valid grades entered
        // total = sum of valid grades
        int count = 0;
        int total = 0;

        /*
         * Step 2 & Step 3:
         * Use a loop to read quiz grades from the keyboard.
         * Stop when:
         *  - 10 valid grades have been entered, OR
         *  - the user enters the sentinel value 999.
         * Only store values in the range 0-100.
         */
        while (count < 10) {
            System.out.print("Enter quiz grade (0-100) or 999 to quit: ");

            // Input validation: if the next token is not an integer, discard it and prompt again.
            if (!sc.hasNextInt()) {
                String bad = sc.next();
                System.out.println("Invalid input: " + bad + " (Please enter an integer.)");
                continue;
            }

            int grade = sc.nextInt();

            // Sentinel value: stop early (999 is not stored as a grade).
            if (grade == 999) {
                break;
            }

            // Range validation: only accept 0-100.
            if (grade < 0 || grade > 100) {
                System.out.println("Grade must be between 0 and 100. Try again.");
                continue;
            }

            // Store the valid grade and update running totals.
            grades[count] = grade;
            total += grade;
            count++;
        }

        /*
         * Step 4:
         * Use a second loop to display all stored grades.
         * If no grades were entered, exit gracefully.
         */
        System.out.println("\n--- Grades Entered ---");
        if (count == 0) {
            System.out.println("No grades were entered.");
            sc.close();
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Grade " + (i + 1) + ": " + grades[i]);
        }

        // Step 5: Compute and display the average score.
        double average = (double) total / count;
        System.out.printf("\nAverage: %.2f%n", average);

        // Step 6: Determine and display the letter grade based on the average.
        char letter = getLetterGrade(average);
        System.out.println("Letter Grade: " + letter);

        sc.close();
    }
}

