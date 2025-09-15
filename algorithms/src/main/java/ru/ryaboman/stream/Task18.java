package ru.ryaboman.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task18 {

    public static void main(String[] args) {
        List<Department> list = List.of(
                new Department("IT")
                        .addPerson(new Person("Valera", 90))
                        .addPerson(new Person("Masha", 240))
                        .addPerson(new Person("Sasha", 300)),
                new Department("Manager")
                        .addPerson(new Person("Nadya", 190))
                        .addPerson(new Person("Petr", 160)),
                new Department("HR")
                        .addPerson(new Person("Vova", 130))
                        .addPerson(new Person("Seva", 210))
                        .addPerson(new Person("Monika", 170))
        );

        //Необходимо найти сумму зарплат всех сотрудников по отделам
        Map<String, Integer> sumSalaryForDepartment = list.stream()
                .collect(Collectors.toMap(Department::getName,
                        d -> d.getPersons().stream()
                        .mapToInt(Person::getSalary).sum()
                        )
                );

        System.out.println(sumSalaryForDepartment);
    }

    static class Department {
        private String name;
        private List<Person> persons;

        public Department(String name) {
            this.name = name;
            persons = new ArrayList<>();
        }

        public Department addPerson(Person person) {
            persons.add(person);
            return this;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Person> getPersons() {
            return persons;
        }

        public void setPersons(List<Person> persons) {
            this.persons = persons;
        }
    }

    static class Person {
        private String name;
        private int salary;

        public Person(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
