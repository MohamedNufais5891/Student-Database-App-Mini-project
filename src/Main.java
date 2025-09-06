import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentDAO dao = new StudentDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Student Database Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println("👋 Exiting program...");
                    System.exit(0);
                }
                default -> System.out.println("❌ Invalid choice, try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(name, age, grade);
        dao.addStudent(student);
    }

    private static void viewStudents() {
        List<Student> students = dao.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("⚠️ No students found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Grade: ");
        String grade = scanner.nextLine();

        dao.updateStudent(id, name, age, grade);
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        dao.deleteStudent(id);
    }
}
