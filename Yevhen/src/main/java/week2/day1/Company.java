package week2.day1;

/**
 * Created by gorobec on 08.04.17.
 */
public class Company {
    private String name;
    private Employee[] employees;
    private int counter;


    public Company(String name, int size) {
        this.name = name;
        this.employees = new Employee[size];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public boolean addEmployee(Employee employee){
        if(employee == null) return false;
        if(counter == employees.length || contains(employees, employee)) return false;
        employees[counter++] = employee;
        return true;
    }

    private boolean contains(Employee[] employees, Employee employee) {
        for (int i = 0; i < counter; i++) {
            if (employees[i].getName().equals(employee.getName())
                    && employees[i].getSurname().equals(employee.getSurname())) {
                return true;

            }
        }
            return false;
    }

    public boolean removeEmployee(Employee employee) {
        if(employee == null) return false;
        int position = findPosition(employee);
        if(position == -1) {
            return false;
        } else {
/*public static native void arraycopy(Object src,  int  srcPos,
                            Object dest, int destPos,
                            int length);*/
            System.arraycopy(employees, position + 1, employees, position, counter - position - 1);
            counter--;
            return true;
        }
    }

    private int findPosition(Employee employee) {
        for (int i = 0; i < counter; i++) {
            if (employees[i].getName().equals(employee.getName())
                    && employees[i].getSurname().equals(employee.getSurname())) {
                return i;

            }
        }
        return -1;
    }

    public void showEmployee(){
        for (int i = 0; i < counter; i++) {
            System.out.println(employees[i].toString());
        }
    }
}
