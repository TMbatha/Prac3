package za.ac.cput;

import java.util.*;
import javax.swing.JOptionPane;

/**
 * RunEmployee.java 12/02/2024
 *
 * @author Thabiso Mbatha
 */
public class RunEmployee {

    private static String name, surname, number;
    private static double salary;
    private static ArrayList<Employee> empList = new ArrayList<>();

    public static Employee createEmployee() {
        name = JOptionPane.showInputDialog("Enter Employee Name");
        surname = JOptionPane.showInputDialog("Enter Employee Surname");
        number = JOptionPane.showInputDialog("Enter Employee Number");

        String tempSalary = JOptionPane.showInputDialog("Enter Employee Salary");
        salary = Double.parseDouble(tempSalary);

        Employee emp = new Employee(name, surname, number, salary);

        return emp;
    }

    public static void viewEmployees() {
        for (Employee emp : empList) {
            JOptionPane.showMessageDialog(null, emp, "EMPLOYEE DETAILS", 1);
        }
    }

    public static void sortEmployees() {
        String input = JOptionPane.showInputDialog("Sort Employees According to\n"
                + "1. Ascending Order Of Salary\n"
                + "2. Ascending Order Of Surname \n"
                + "3. Back");

        switch (input) {
            case ("1"):

                Collections.sort(empList, new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        return Double.valueOf(o1.getEmpSalary()).compareTo(o2.getEmpSalary());
                    }
                });

                JOptionPane.showMessageDialog(null, "Sorted!", "SORT OFDER OF SALARY", 1);
                break;
            case ("2"):
                Collections.sort(empList, new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        return o1.getEmpSurame().compareToIgnoreCase(o2.getEmpSurame());
                    }
                });
                JOptionPane.showMessageDialog(null, "Sorted", "SORD ORDER OF SURNAME", 1);
                break;
            case ("3"):
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Input.", "ERROR", 0);
                break;
        }
    }

    public static void removeEmployees() {
        String input = JOptionPane.showInputDialog("Remove Employees According to\n"
                + "1. First Letter Of Surname\n"
                + "2. Salary Less Than Or Equal To\n"
                + "3. Back");

        List<Employee> copyList = new ArrayList<>(empList);//Creates Copy of original ArrayList

        switch (input) {
            case ("1"):
                String input1 = JOptionPane.showInputDialog("Enter First Letter Of\nSurnames To Be Removed");
                //char convertedInput = input1.charAt(0);

                for (Employee emp : copyList) {//Iteration over the copy of the ArrayList
                    char x = emp.getEmpSurame().charAt(0);//Converting first letter of employees name to a character type
                    String character = String.valueOf(x);//Converting the character back to string value
                    
                    /*if (x == convertedInput) {//condtion that compares characters
                        empList.remove(emp);//removes employee object if condition is true
                        JOptionPane.showMessageDialog(null, emp.getEmpName() + " has been removed.");
                    }*/
                    
                    if(input1.equalsIgnoreCase(character)){//condition compares string objects
                        empList.remove(emp);
                        JOptionPane.showMessageDialog(null, emp.getEmpName() + " has been removed.");
                    }
                    
                }
                break;
            case ("2"):
                String input2 = JOptionPane.showInputDialog("Enter Amount");
                double amount = Double.parseDouble(input2);

                for (Employee emp : copyList) {
                    if (emp.getEmpSalary() <= amount) {
                        JOptionPane.showMessageDialog(null, emp.getEmpName() + " has been removed");
                        empList.remove(emp);
                    }
                }
                break;
            case ("3"):
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Input.");
                break;
        }
    }

    public static void main(String[] args) {

        int control = 1;
        while (control == 1) {
            String input = JOptionPane.showInputDialog("What Would You Like To Do?" + "\n"
                    + "1. Add Employee \n"
                    + "2. View Employees \n"
                    + "3. Sort \n"
                    + "4. Remove Employees\n"
                    + "5. Exit");
            switch (input) {
                case ("1"):
                    empList.add(RunEmployee.createEmployee());
                    break;
                case ("2"):
                    RunEmployee.viewEmployees();
                    break;
                case ("3"):
                    RunEmployee.sortEmployees();
                    break;
                case ("4"):
                    RunEmployee.removeEmployees();
                    break;
                case ("5"):
                    control -= 1;
                    JOptionPane.showMessageDialog(null, "Thank You");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid input.");
                    break;
            }
        }

    }
}
