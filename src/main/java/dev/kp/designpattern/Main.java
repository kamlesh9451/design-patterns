package dev.kp.designpattern;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = Employee.getEmployeeList();
        //1.How many employees are there in the organization ?
        long noOfEmps = employeeList.stream()
                .count();
        System.out.println(noOfEmps);
        long noOfEmps1 = employeeList.stream().collect(Collectors.counting());
        System.out.println(noOfEmps1);

        //2. Sort the List of Employee objects based on salary in Ascending order.
 
        List<Employee> sortedBySal = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
        System.out.println(sortedBySal);

        //3. Sort the List of Employee objects based on salary in Descending order
        List<Employee> sortedBySalSes = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(sortedBySalSes);

        //4. How many male and female employees are there in the organization?
        Map<String, Long> map = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        for (Map.Entry<String, Long> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        //5. How many employees are there in each department?
        Map<String, Long> empByDepart = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        for (Map.Entry<String, Long> entry : empByDepart.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // 6. Get the name of all the department
        List<String> listOfDepts = employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        listOfDepts.forEach(System.out::println);


        // 7. Find the average salary of the male and female employee

        Map<String, Double> avgSalaryByGen = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryByGen);

        //8. Fetch the highest-paid male and female employee

        Map<String, Optional<Employee>> maxSalaryMaleAndFemaleEmployee = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println(maxSalaryMaleAndFemaleEmployee);

        //9. Fetch the lowest-paid male and female employee
        Map<String, Optional<Employee>> minSalaryMaleAndFemaleEmployee = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.minBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println(minSalaryMaleAndFemaleEmployee);
        System.out.println(minSalaryMaleAndFemaleEmployee);

        //10. Get the highest-paid employee in each department

        Map<String, Optional<Employee>> minSalaryEmployeeByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println(minSalaryEmployeeByDept);

        //11. Get the details of the highest paid employee in the organization?

        Optional<Employee> highestPaidEmployeeWrapper = employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(highestPaidEmployeeWrapper);

        //12. Find the average salary of each department?
        Map<String, Double> avgSalaryOfDepartments = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        for (Map.Entry<String, Double> entry : avgSalaryOfDepartments.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        //13. Get the details of the youngest male employee in the product development department?


        Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper = employeeList.stream()
                .filter(e -> e.getGender() == "Male" && Objects.equals(e.getDepartment(), "Product Development"))
                .collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge)));
        System.out.println(youngestMaleEmployeeInProductDevelopmentWrapper);

        //14. Who has the most working experience in the organization?

        Optional<Employee> seniorMostEmployeeWrapper =
                employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining))
                        .findFirst();
        //OR
        Optional<Employee>  seniorMostEmployeeWrapper1 = employeeList.stream()
                        .collect(Collectors.maxBy(Comparator.comparingInt(Employee::getYearOfJoining)));
        seniorMostEmployeeWrapper.ifPresent(System.out::println);
        //OR

        seniorMostEmployeeWrapper = employeeList.stream()
                .min(Comparator.comparingInt(Employee::getYearOfJoining));

        seniorMostEmployeeWrapper.ifPresent(System.out::println);

        // 15. Who is the oldest employee in the organization?

        Optional<Employee> oldestEmployeeWrapper = employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge)));
        oldestEmployeeWrapper.ifPresent(System.out::println);

        //16. What is the average salary and total salary of the whole organization?

        DoubleSummaryStatistics employeeSalaryStatistics = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(employeeSalaryStatistics);
        //DoubleSummaryStatistics{count=17, sum=583701.000000, min=20500.000000, average=34335.352941, max=62500.000000}

        //17. List down the names of all employees in each department?

        Map<String, List<Employee>> employeeListByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        for (Map.Entry<String, List<Employee>> entry : employeeListByDepartment.entrySet()) {
            System.out.println("--------------------------------------");
            System.out.println("Employees In " + entry.getKey() + " : ");
            System.out.println("--------------------------------------");
            List<Employee> list = entry.getValue();
            for (Employee e : list) {
                System.out.println(e.getName());
            }
        }


        // 18. Separate the employees who are younger or equal to 30 years from those older than 30 years.

        Map<Boolean, List<Employee>> partitionEmployeesByAge = employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 30));

        for (Map.Entry<Boolean, List<Employee>> entry : partitionEmployeesByAge.entrySet()) {
            if (entry.getKey()) {
                System.out.println("Employees older than 30 years :");
            } else {
                System.out.println("Employees younger than or equal to 30 years :");
            }

            System.out.println("----------------------------");

            List<Employee> list = entry.getValue();

            for (Employee e : list) {
                System.out.println(e.getName());
            }
        }


        Map<Boolean, List<Employee>> wealthyEmployees = employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 50000));

        List<Employee> highEarners = wealthyEmployees.get(true);
        List<Employee> regularEarners = wealthyEmployees.get(false);


        // Given a list of employees, group them by a custom key representing their salary range ("Low", "Medium", "High").
        // Then, for each salary range, find the average sal  ary.


        // Group by salary range and calculate average salary
        Map<String, Double> averageSalaryByRange = employeeList.stream()
                .collect(Collectors.groupingBy(
                        e -> {
                            if (e.getSalary() < 50000) return "Low";
                            if (e.getSalary() < 100000) return "Medium";
                            return "High";
                        }
                        ,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        System.out.println(averageSalaryByRange);

        //19. How do you find duplicate elements in a stream?

        List<String> list = Arrays.asList("apple", "banana", "apple", "orange", "banana");

        Set<String> duplicateString = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println(duplicateString);

        //OR using set
        Set<String> set = new HashSet<>();
        list.stream()
                .filter(s->!set.add(s))
                .forEach(System.out::println);

        List<String> list1 = Arrays.asList("apple", "banana", "apple", "orange", "banana","tests");
        Set<String> set1 = new HashSet<>();
        list.stream()
                .collect(Collectors.groupingBy(s->s, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue() == 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

        String fisrt = list.stream()
                .collect(Collectors.groupingBy(s->s,LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().get();
        System.out.println(fisrt);

        //20. How do you find the second highest number in a list?

        List<Integer> numbers = Arrays.asList(10, 20, 3, 5, 25, 20);
        Optional<Integer> secondHighest = numbers.stream()
                .sorted(Collections.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst();
        System.out.println(secondHighest.get());

        //21. Given a list of strings, use reduce to find the string with the longest length.
        List<String> words = Arrays.asList("Java", "Stream", "API", "Interview", "Question");

        Optional<String> longestWord =  words.stream()
                .reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);
        System.out.println(longestWord.orElse("empty"));


        //22. Convert a list of Employee to a Map with employee ID as the key and Employee object as the value. Employees with same Id first should be retained.
      Map<Integer, Employee> employeeMap = employeeList.stream()
                .collect(Collectors.toMap(Employee::getId, e->e, (existing, replacement) -> existing));
      System.out.println(employeeMap);
        Map<Integer, Employee> employeeMap1 = employeeList.stream()
                .collect(Collectors.toMap(Employee::getId, Function.identity(), (existing, replacement) -> existing));
        System.out.println(employeeMap);

        //To required Map like LinkedHashMap or TreeMap use following way
        Map<Integer, Employee> employeeLinkedHashMap = employeeList.stream()
                .collect(Collectors.toMap(Employee::getId, e->e, (e1,e2)->e1, LinkedHashMap::new));

        Map<Integer, Employee> employeeLinkedHashMap1 = employeeList.stream()
                .collect(Collectors.toMap(Employee::getId, e->e, (e1,e2)->e1, ()->new LinkedHashMap<>()));

        Map<Integer, Employee> employeeTreeMapDesc = employeeList.stream()
                .collect(Collectors.toMap(
                        Employee::getId,          // keyMapper → employee ID
                        e -> e,                   // valueMapper → employee object
                        (e1, e2) -> e1,           // merge function → keep the first on duplicate keys
                        () -> new TreeMap<>(Comparator.reverseOrder()) // map supplier → TreeMap with DESC order
                ));

        Map<Integer, Employee> employeeTreeMapDesc1 = employeeList.stream()
                .collect(Collectors.toMap(
                        Employee::getId,          // keyMapper → employee ID
                        e -> e,                   // valueMapper → employee object
                        (e1, e2) -> e1,           // merge function → keep the first on duplicate keys
                        () -> new TreeMap<>((key1, key2)->{
                           return key2.compareTo(key1);
                        }) // map supplier → TreeMap with DESC order
                ));

        Map<Integer, String> employeeTreeMapDescWithName = employeeList.stream()
                .collect(Collectors.toMap(
                        Employee::getId,          // keyMapper → employee ID
                        e -> e.name,                   // valueMapper → employee object
                        (e1, e2) -> e1,           // merge function → keep the first on duplicate keys
                        () -> new TreeMap<>((key1, key2)->{
                            return key2.compareTo(key1);
                        }) // map supplier → TreeMap with DESC order
                ));

        System.out.println(employeeLinkedHashMap);
        System.out.println(employeeTreeMapDesc);
        System.out.println(employeeTreeMapDesc1);
        System.out.println(employeeTreeMapDescWithName);

        //23. Convert Map<Integer, Employee> to List<Employee>
        List<Employee> empListFromMap = employeeMap.values().stream().toList();

        //24. Find unique
        List<String> list11 = Arrays.asList("apple", "banana", "apple", "orange", "banana","tests");

        list.stream()
                .collect(Collectors.groupingBy(s->s, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue() == 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

        String fisrt1 = list.stream()
                .collect(Collectors.groupingBy(s->s, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().get();
        System.out.println(fisrt);



    }
}


class Employee {
    int id;

    String name;

    int age;

    String gender;

    String department;

    int yearOfJoining;

    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : " + id
                + ", Name : " + name
                + ", age : " + age
                + ", Gender : " + gender
                + ", Department : " + department
                + ", Year Of Joining : " + yearOfJoining
                + ", Salary : " + salary;
    }

    public static List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jennifer", 22, "Female", "HR", 2017, 55000.0));
        employeeList.add(new Employee(111, "Jennifer1", 22, "Female", "HR", 2017, 55000.0));
        employeeList.add(new Employee(112, "Rohit", 35, "Male", "Sales And Marketing", 2019, 23500.0));
        employeeList.add(new Employee(113, "Shubman", 29, "Male", "Infrastructure", 2019, 28000.0));
        employeeList.add(new Employee(114, "Rinku", 28, "Male", "Product Development", 2020, 62500.0));
        employeeList.add(new Employee(115, "Aaditi", 41, "Female", "HR", 2022, 29700.0));
        employeeList.add(new Employee(116, "Mahendra", 43, "Male", "Security And Transport", 2023, 20500.0));
        employeeList.add(new Employee(117, "Nitish", 35, "Male", "Account And Finance", 2019, 37000.0));
        employeeList.add(new Employee(118, "Aditya", 31, "Male", "Product Development", 2019, 34500.0));
        employeeList.add(new Employee(119, "Monika", 24, "Female", "Sales And Marketing", 2021, 21500.0));
        employeeList.add(new Employee(120, "Aman", 38, "Male", "Security And Transport", 2021, 31000.5));
        employeeList.add(new Employee(121, "Sangeeta", 27, "Female", "Infrastructure", 2021, 35000.0));
        employeeList.add(new Employee(122, "Joshi", 25, "Male", "Product Development", 2020, 29000.0));
        employeeList.add(new Employee(123, "Jeddy", 27, "Female", "Account And Finance", 2020, 29000.0));
        employeeList.add(new Employee(124, "Niden", 24, "Male", "Sales And Marketing", 2020, 30200.5));
        employeeList.add(new Employee(125, "Saig", 23, "Male", "Infrastructure", 2019, 42700.0));
        employeeList.add(new Employee(126, "Saey", 26, "Female", "Product Development", 2018, 38900.0));
        employeeList.add(new Employee(127, "Shreyas", 25, "Male", "Product Development", 2018, 35700.0));

        return employeeList;
    }
}