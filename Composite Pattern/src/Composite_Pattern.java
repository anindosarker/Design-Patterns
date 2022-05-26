import java.util.ArrayList;
import java.util.List;

interface Employee{
    public void showEmployeeDetails();
}
class Developer implements Employee{
    private String name;
    private String employee_id;
    public Developer(String name, String emp_id){
        this.employee_id = emp_id;
        this.name = name;
    }
    @Override
    public void showEmployeeDetails() {
        System.out.println("Name : " + this.name + ", Emp_ID: " + this.employee_id);
    }
}

class Manager implements Employee{
    private String name;
    private String employee_id;
    public Manager(String name, String emp_id){
        this.employee_id = emp_id;
        this.name = name;
    }
    @Override
    public void showEmployeeDetails() {
        System.out.println("Name : " + this.name + ", Emp_ID: " + this.employee_id);
    }
}

class CompanyDirectory implements Employee{
    private List<Employee> employeeList = new ArrayList<Employee>();



    @Override
    public void showEmployeeDetails() {
        for (Employee emp: employeeList){
            emp.showEmployeeDetails();
        }
    }


    public void addEmployee(Employee emp){
        employeeList.add(emp);
    }

    public void removeEmployee(Employee emp){
        employeeList.remove(emp);
    }
}



public class Composite_Pattern {
    public static void main(String[] args) {
        // dev leaf
        Developer dev1 = new Developer("Siam", "001");
        Developer dev2 = new Developer("Tunan", "002");
        //composite engDir
        CompanyDirectory engineersDirectory = new CompanyDirectory();
        engineersDirectory.addEmployee(dev1);
        engineersDirectory.addEmployee(dev2);

        //manager leaf
        Manager manager1 = new Manager("Tabgit", "003");
        Manager manager2 = new Manager("Anindo", "004");

        //composite manDir
        CompanyDirectory managerDirectory = new CompanyDirectory();
        managerDirectory.addEmployee(manager1);
        managerDirectory.addEmployee(manager2);

        CompanyDirectory directory = new CompanyDirectory();
        directory.addEmployee(engineersDirectory);
        directory.addEmployee(managerDirectory);

        directory.showEmployeeDetails();
    }
}
