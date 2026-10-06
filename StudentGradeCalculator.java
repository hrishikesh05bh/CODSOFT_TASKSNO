import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of subjects: ");
            int subjects;

            while (true) {
                if (sc.hasNextInt()) {
                    subjects = sc.nextInt();
                    if (subjects > 0) {
                        break;
                    }
                } else {
                    sc.next();
                }
                System.out.println("Please enter a valid positive number of subjects.");
                System.out.print("Enter number of subjects: ");
            }

            int total = 0;

            for (int i = 1; i <= subjects; i++) {
                int marks;
                while (true) {
                    System.out.print("Enter marks for subject " + i + ": ");
                    if (sc.hasNextInt()) {
                        marks = sc.nextInt();
                        if (marks >= 0 && marks <= 100) {
                            break;
                        }
                    } else {
                        sc.next();
                    }
                    System.out.println("Marks must be a whole number between 0 and 100.");
                }
                total += marks;
            }

            double percentage = (double) total / subjects;
            String grade;

            if (percentage >= 90) {
                grade = "A+";
            } else if (percentage >= 80) {
                grade = "A";
            } else if (percentage >= 70) {
                grade = "B";
            } else if (percentage >= 60) {
                grade = "C";
            } else if (percentage >= 50) {
                grade = "D";
            } else {
                grade = "F";
            }

            System.out.println("\nTotal Marks: " + total);
            System.out.printf("Average Percentage: %.2f%%\n", percentage);
            System.out.println("Grade: " + grade);
        }
    }
}