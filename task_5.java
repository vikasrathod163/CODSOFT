import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

class Student implements Serializable {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }


    public int getRollNumber() {
        return rollNumber;
    }

    @Override
    public String toString() {
        return "\nName : " + name + "\nRoll Number : " + rollNumber + "\nGrade : " + grade+"\n";
    }
}

class StudentManagementSystem {
    private static final int MAX_STUDENTS = 100;
    private Student[] students = new Student[MAX_STUDENTS];
    private int count = 0;

    public void addStudent(Student student) {
        if (count < MAX_STUDENTS) {
            students[count++] = student;
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Cannot add more students. Maximum limit reached.");
        }
    }

    public void removeStudent(int rollNumber) {
        for (int i = 0; i < count; i++) {
            if (students[i].getRollNumber() == rollNumber) {
                
                // Move remaining elements to fill the gap
                System.arraycopy(students, i + 1, students, i, count - i - 1);
                count--;
                System.out.println("Student removed successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public Student searchStudent(int rollNumber) {
        
        for (int i = 0; i < count; i++) {
            if (students[i].getRollNumber() == rollNumber) {
                return students[i];
            }
        }
        
        return null; // if record not found.....
    }

    public void displayAllStudents() {
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }
    
    public void writeToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(students);
            System.out.println("Data saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            students = (Student[]) ois.readObject();
            count = students.length;
            System.out.println("Data loaded from file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

public class task_5{
    public static void main(String[] args) {
        
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(" | 1 : Add a new student    |");
            System.out.println(" | 2 : Remove a student     |");
            System.out.println(" | 3 : Search for a student |");
            System.out.println(" | 4 : Display all student  |");
            System.out.println(" | 5 : Save data to file    |");
            System.out.println(" | 6 : Load data from file  |");
            System.out.println(" | 7 : Exit                 |");

            System.out.print("\t\t	Enter your choice : ");

            int choice;
            try {
                choice = sc.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    
                    System.out.print("Enter student name : ");
                    String name = sc.next();
                    System.out.print("Enter roll number : ");
                    int rollNumber = sc.nextInt();
                    System.out.print("Enter grade : ");
                    String grade = sc.next();

                    system.addStudent(new Student(name, rollNumber, grade));
                    break;

                case 2:
                    
                    System.out.print("Enter roll number to remove: ");
                    int rollno = sc.nextInt();
                    system.removeStudent(rollno);
                    break;

                case 3:
                    
                    System.out.print("Enter roll number to search: ");
                    int rollToSearch = sc.nextInt();
                    Student foundStudent = system.searchStudent(rollToSearch);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    
                    system.displayAllStudents();
                    break;
				case 5:
                    // Save data to file
                    System.out.print("Enter file name to save data: ");
                    String saveFileName = sc.next();
                    system.writeToFile(saveFileName);
                    break;

                case 6:
                    // Load data from file
                    System.out.print("Enter file name to load data: ");
                    String loadFileName = sc.next();
                    system.readFromFile(loadFileName);
                    break;
                    
                case 7:
                   
                    System.out.println("Exiting the Student Management System.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
