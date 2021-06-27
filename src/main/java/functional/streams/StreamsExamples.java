package functional.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsExamples {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Dan", 45),
                new Employee("Trish", 23),
                new Employee("Tom", 58),
                new Employee("Velma", 28),
                new Employee("Shag", 32),
                new Employee("Warren", 20)
        );

        //Filter employees whose age is greater than 30
        List<Employee> filteredEmployees = employees.stream().filter(e -> e.getAge() > 30).collect(Collectors.toList());
        //Using method reference in lambda
        System.out.println("---------Employees with age >30---------");
        filteredEmployees.forEach(System.out::println);

        //Count number of employees with age greater than 25
        System.out.println("-------No of employees with age > 25-------");
        System.out.println(employees.stream().filter(e -> e.getAge() > 25).count());

        //Find an employee with name Velma
        System.out.println("-------Employee with name velma-------");
        System.out.println(employees.stream().filter(e -> e.getName().equals("Velma")).findAny());

        //get the max age from the list of employees
        System.out.println("-------Sort employees based on age-------");
        System.out.println(employees.stream().mapToInt(Employee::getAge).max().getAsInt());

        //Sort employees based on age
        System.out.println("------Sorting employees based on age in Ascending order------");
        //Ascending order
        employees.sort(Comparator.comparingInt(Employee::getAge));
        //employees.sort((e1,e2) -> e1.getAge()-e2.getAge());
        employees.forEach(System.out::println);

        //Descending order
        System.out.println("------Sorting employees based on age in Descending order------");
        employees.sort((e1, e2) -> e2.getAge() - e1.getAge());
        employees.forEach(System.out::println);

        //Get an employee who has max salary
        System.out.println("-----Get an employee who has max Age-----");
        Optional<Employee> employee = employees.stream().max(Comparator.comparing(Employee::getAge));

        //Join the all employee names with “,”
        System.out.println("------Join the all employee names with “,”------");
        List<String> employeeNames = employees.stream().map(Employee::getName).collect(Collectors.toList());
        String employeeNamesStr = String.join(",", employeeNames);
        System.out.println(employeeNamesStr);

        //Remove duplicates from an integer array
        Integer[] arr = new Integer[]{1, 2, 3, 4, 3, 2, 4, 2};
        Set<Integer> setWithoutDups = new HashSet<>(Arrays.asList(arr));
        Set<Integer> setWithoutDups1 = Arrays.asList(arr).stream().collect(Collectors.toSet());

        System.out.println("-------non duplicate numbers - hashset array as list-------");
        setWithoutDups.forEach(System.out::println);
        System.out.println("-------non duplicate numbers - via streams-------");
        setWithoutDups1.forEach(System.out::println);

        //Given a list of numbers, square them and
        // filter the numbers which are greater 10000 and then find average of them.( Java 8 APIs only)
        System.out.println("--------Square, greater than 10000 and average-------");
        Integer[] nums = new Integer[]{100, 24, 13, 44, 114, 200, 40, 112};

        OptionalDouble average = Arrays.stream(nums)
                .mapToInt(n -> n * n)
                .filter(n -> n > 10000)
                .average();

        if (average.isPresent()) {
            System.out.println("Average is " + average.getAsDouble());
        } else {
            System.out.println("No numbers are above 10000");
        }

        List<EmployeeWithSalary> employeesWithSalaries = Arrays.asList(
                new EmployeeWithSalary("Dan", 45,10000),
                new EmployeeWithSalary("Trish", 23,20000),
                new EmployeeWithSalary("Tom", 58,5000),
                new EmployeeWithSalary("Velma", 28,50000),
                new EmployeeWithSalary("Shag", 32,80000),
                new EmployeeWithSalary("Warren", 20,25000)
        );

        // Get list of employees with salary greater than 20000 and age greater than 25
        List<EmployeeWithSalary> employeesWithGreater20kAndAgeGreater25 =
                employeesWithSalaries.stream()
                        .filter(e -> e.getSalary()>20000 && e.getAge()>25)
                .collect(Collectors.toList());

        System.out.println("--------- list of employees with salary greater than 20000 and age greater than 25 ---------");
        System.out.println(employeesWithGreater20kAndAgeGreater25);

        System.out.println("----- Sum of all Salaries -----");
        System.out.println(employeesWithSalaries.stream().map(EmployeeWithSalary::getSalary).reduce(Double::sum));

        System.out.println("----- Employee with max salary -----");
        System.out.println(employeesWithSalaries.stream().max(Comparator.comparing(EmployeeWithSalary::getSalary)));

        System.out.println("----- Employee with min salary -----");
        System.out.println(employeesWithSalaries.stream().min(Comparator.comparing(EmployeeWithSalary::getSalary)));

        System.out.println("---- employees with name starting with 'T' -----");
        System.out.println(employeesWithSalaries.stream().filter(s -> s.getName().startsWith("T")).collect(Collectors.toList()));


    }

}
