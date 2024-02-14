package za.ac.cput;

/**
 * Employee.java 12/02/2024
 *
 * @author Thabiso Mbatha
 */
public class Employee {

    private String empName, empSurname, empNumber;
    private double empSalary;

    public Employee() {

    }

    public Employee(String name, String surname, String number, double salary) {
        this.empName = name;
        this.empSurname = surname;
        this.empNumber = number;
        this.empSalary = salary;
    }

    public void setEmpName(String name) {
        this.empName = name;
    }

    public void setEmpSurname(String surname) {
        this.empSurname = surname;
    }

    public void setEmpNumber(String number) {
        this.empNumber = number;
    }

    public void setEmpSalary(double salary) {
        this.empSalary = salary;
    }
    
    public String getEmpName(){
        return empName;
    }
    public String getEmpSurame(){
        return empSurname;
    }
    public String getEmpNumber(){
        return empNumber;
    }
    public double getEmpSalary(){
        return empSalary;
    }
    
    @Override
    public String toString(){
        return "Name: " + empName + "\n"
                + "Surname: " + empSurname + "\n"
                + "Number: " + empNumber + "\n"
                + "Salary: " + empSalary + "\n\n";
    }

}
