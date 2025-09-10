package ru.ryaboman.stream;

import java.util.List;

public class Task15 {
    /**
     * Подсчитать количество работников с зарплатой больше чем введенная salary >= threshold (только тех, чей отдел содержит в коде 111- )
     *
     * @param departments are list of departments
     * @param threshold is lower edge of salary
     *
     * @return the number of employees
     */

    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        // write your code here
        return departments.stream()
                .filter(d -> d.getCode().contains("111-"))
                .flatMap(d -> d.getEmployees().stream())
                .filter(d -> d.getSalary() >= threshold)
                .count();
    }

    public static void main(String[] args) {
        List<Department> departments = List.of(
                new Department("dep-1", "111-1", List.of(
                        new Employee("William", 15000L),
                        new Employee("Sophia", 22000L),
                        new Employee("John", 20000L)
                )),
                new Department("dep-2", "222-1", List.of(
                        new Employee("Victor", 25000L)
                ))
        );
        System.out.println(calcNumberOfEmployees(departments, 20000L));
    }

    static class Employee {
        private final String name;
        private final Long salary;

        public Employee(String name, Long salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public Long getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    static class Department {
        private final String name;
        private final String code;
        private final List<Employee> employees;

        public Department(String name, String code, List<Employee> employees) {
            this.name = name;
            this.code = code;
            this.employees = employees;
        }

        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "name='" + name + '\'' +
                    ", code='" + code + '\'' +
                    ", employees=" + employees +
                    '}';
        }
    }
}
