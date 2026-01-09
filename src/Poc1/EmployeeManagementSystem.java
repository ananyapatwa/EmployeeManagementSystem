package Poc1;
import java.util.*;
import java.util.stream.Collectors;
class Employee {  // data members
    int id;
    String name;
    String department;
    double salary;
    // making a constructor to help in the object calling
    Employee(int id,String name, String department, double salary){
        this.id=id;
        this.name=name;
        this.department=department;
        this.salary=salary;
    }
    public String toString(){
        return  id + " " + name + " " + department + " " + salary;
    }
}
public class EmployeeManagementSystem{
    static Scanner sc = new Scanner(System.in);
    static Map<Integer,Employee> employeeMap=new HashMap<>();
    public static void main(String[] args) {
        int choice;
        do{
            System.out.println("Employee management system:");
            System.out.println("Choose 1 for Add employee");
            System.out.println("Choose 2 for View all employee");
            System.out.println("Choose 3 for Filter by department");
            System.out.println("Choose 4 for Sort by salary");
            System.out.println("Choose 5 for Salary Analytics");
            System.out.println("Choose 6 for Find employee by id");
            System.out.println("Choose 7 for Exit");
            System.out.println("Enter your choice(1-7):");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployee();
                    break;
                case 3:
                    filterByDept();
                    break;
                case 4:
                    sortbysalary();
                    break;
                case 5:
                    salaryAnalytics();
                    break;
                case 6:
                    findbyId();
                    break;
                case 7:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid");
            }
        } while (choice!=7);
    }
    static void addEmployee(){
        System.out.println("Enter ID:");
        int id =sc.nextInt();
        if(employeeMap.containsKey(id)){
            System.out.println("Employee with this id already exists");
        }
        System.out.println("Enter name:");
        String name = sc.next();
        System.out.println("Enter Department:");
        String dept = sc.next();
        System.out.println("Enter salary:");
        double salary = sc.nextDouble();
        employeeMap.put(id, new Employee(id,name,dept,salary));
        System.out.println("Employee added succesfully");
    }
    static void viewEmployee(){
        employeeMap.values().forEach(System.out::println);
    }
    static void filterByDept(){
        System.out.println("Enter department:");
        String dept = sc.next();
        employeeMap.values().stream().filter(e->e.department.equalsIgnoreCase(dept)).forEach(System.out::println);
    }
    static void sortbysalary(){
        employeeMap.values().stream().sorted(Comparator.comparingDouble(e->e.salary)).forEach(System.out::println);
    }
    static void salaryAnalytics(){
        DoubleSummaryStatistics stats= employeeMap.values().stream().collect(Collectors.summarizingDouble(e->e.salary));
        System.out.println("Max salary:" + stats.getMax());
        System.out.println("Min salary:" + stats.getMin());
        System.out.println("Average salary:" + stats.getAverage());
        System.out.println("Total salary:" + stats.getSum());
    }
    static  void findbyId(){
        System.out.println("Enter ID");
        int id = sc.nextInt();
        Employee emp = employeeMap.get(id);
        if(emp!=null){
            System.out.println(emp);
        }
        else
            System.out.println("Employee not found");
    }
}
