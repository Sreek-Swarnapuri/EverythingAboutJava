package functional.streams;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class EmployeeWithSalary extends Employee {

    private double salary;

    public EmployeeWithSalary(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeWithSalary{" +
                "name=" + super.getName() +
                ", age=" + super.getAge() +
                ", salary=" + salary +
                '}';
    }
}
