# ProjectProgram(QuizGrades)

## Overview
This Java console program allows a user to enter up to 10 quiz grades (0–100).  
The user may type **999** at any time to stop entering grades early.  
After input is complete, the program:
1. Displays all grades entered
2. Calculates the average grade
3. Determines and displays the corresponding letter grade (A–F)

## Program Requirements Implemented
- Accept quiz grades from the keyboard using a loop
- Stop input when:
  - 10 grades have been entered, OR
  - the user enters the sentinel value **999**
- Store grades in an array
- Use a second loop to display the stored grades
- Compute the average of the entered grades
- Use decision logic to determine letter grade based on the average:
  - A = 90–100
  - B = 80–89
  - C = 70–79
  - D = 60–69
  - F = 0–59

## Input Rules
- Valid quiz grades are integers from **0 to 100**
- Enter **999** to stop early (999 is not counted as a grade)
- If an invalid value is entered (not 0–100 and not 999), the program prompts again

## How to Compile & Run

Compile:
- `javac -d bin src\App.java`

Run:
- `java -cp bin App`

> Note: Run these commands in the folder where `App.java` is located (e.g., in PowerShell/Terminal).