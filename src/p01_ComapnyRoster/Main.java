package p01_ComapnyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String,Department> departments =  new LinkedHashMap<>();
        int lines = Integer.parseInt(reader.readLine());
        for (int i = 0; i <lines ; i++) {
                String tokens[] = reader.readLine().split(" ");
                String name = tokens[0];
                double salary=  Double.parseDouble(tokens[1]);
                String position = tokens[2];
                String department = tokens[3];
                Person person= new Person(name,salary,position);

                if(tokens.length==5){
                    try {
                        int age= Integer.parseInt(tokens[4]);
                        person.setAge(age);

                    }catch (Exception e){
                            person.setEmail(tokens[4]);
                    }
                }else if(tokens.length>5){
                    person.setEmail(tokens[4]);
                    person.setAge(Integer.parseInt(tokens[5]));
            }

            if(!departments.containsKey(department)){
                departments.put(department,new Department(department));
            }
               departments.get(department).addPerson(person);


        }
        List<Department> sortedDeparts = departments.values().stream()
                .sorted(Comparator.comparingDouble(Department::getAverage).reversed()).collect(Collectors.toList());
        Department bestDepartment = sortedDeparts.get(0);

        System.out.printf("Highest Average Salary: %s\n",bestDepartment.getName());
        List<Person> sortedPersons = bestDepartment.getPersons().stream()
                .sorted(Comparator.comparing(Person::getSalary).reversed()).collect(Collectors.toList());
        for (Person p : sortedPersons) {
            System.out.printf("%s %.2f %s %s\n",p.getName(),p.getSalary(),p.getEmail(),p.getAge());
        }

    }

}
