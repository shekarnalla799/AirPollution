import java.util.*;

// Employee Class
class Employee {
    String name;
    int id;
    int leaveBalance;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
        this.leaveBalance = 15; // Default leave balance
    }

    public void applyLeave(int days) {
        if (days <= leaveBalance) {
            leaveBalance -= days;
            System.out.println("Leave applied successfully. Remaining leaves: " + leaveBalance);
        } else {
            System.out.println("Insufficient leave balance.");
        }
    }
}

// Leave Management System Class
public class LeaveManagementSystem {
    static Map<Integer, Employee> employees = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLeave Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Apply Leave");
            System.out.println("3. Check Leave Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    applyLeave(scanner);
                    break;
                case 3:
                    checkLeaveBalance(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void addEmployee(Scanner scanner) {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();

        employees.put(id, new Employee(name, id));
        System.out.println("Employee added successfully.");
    }

    static void applyLeave(Scanner scanner) {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter number of days of leave: ");
        int days = scanner.nextInt();

        Employee employee = employees.get(id);
        if (employee != null) {
            employee.applyLeave(days);
        } else {
            System.out.println("Employee not found.");
        }
    }

    static void checkLeaveBalance(Scanner scanner) {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();

        Employee employee = employees.get(id);
        if (employee != null) {
            System.out.println("Leave balance for " + employee.name + ": " + employee.leaveBalance);
        } else {
            System.out.println("Employee not found.");
        }
    }
}
