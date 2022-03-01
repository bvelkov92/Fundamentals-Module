package src.DefiningExercise.CompanyRoster;

public class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public Employee (String name, double salary, String position, String department, String email, int age){
        this.name =name;
        this.salary=salary;
        this.position=position;
        this.department=department;
        this.email=email;
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public Employee (String name, double salary, String position, String department, String email){
        this.name =name;
        this.salary=salary;
        this.position=position;
        this.department=department;
        this.email=email;
        this.age = -1;
    }
    public Employee (String name,double salary,String position, String department,int age){
        this.name =name;
        this.salary=salary;
        this.position=position;
        this.department=department;
        this.email="n/a";
        this.age = age;
    }
    public Employee (String name,double salary,String position, String department){
        this.name =name;
        this.salary=salary;
        this.position=position;
        this.department=department;
        this.email="n/a";
        this.age = -1;
    }

}
