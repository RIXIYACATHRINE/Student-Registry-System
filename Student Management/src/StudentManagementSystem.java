import java.util.*;

class Student {
    int id;
    String name;
    int age;
    String course;

    Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course;
    }
}

public class StudentManagementSystem {
    static Scanner scanner = new Scanner(System.in);
    static Map<Integer, Student> students = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> searchStudent();
                case 6 -> {
                    System.out.println("Exiting... Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();

        if (students.containsKey(id)) {
            System.out.println("❌ Student ID already exists. Please use a different ID.");
            return;
        }

        scanner.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        students.put(id, new Student(id, name, age, course));
        System.out.println("✅ Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.values().forEach(System.out::println);
        }
    }

    static void updateStudent() {
        System.out.print("Enter ID of student to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (students.containsKey(id)) {
            System.out.print("Enter new Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new Course: ");
            String course = scanner.nextLine();

            students.put(id, new Student(id, name, age, course));
            System.out.println("✅ Student updated successfully!");
        } else {
            System.out.println("❌ Student not found.");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter ID of student to delete: ");
        int id = scanner.nextInt();

        if (students.remove(id) != null) {
            System.out.println("✅ Student deleted successfully!");
        } else {
            System.out.println("❌ Student not found.");
        }
    }

    static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = scanner.nextInt();

        Student student = students.get(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("❌ Student not found.");
        }
    }
}


