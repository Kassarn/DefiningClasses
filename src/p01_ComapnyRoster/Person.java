package p01_ComapnyRoster;

public class Person {
 /*: name, salary, position, department, email and age. The name, salary, position and department
 are mandatory while the rest are optional.
  */
        private  String name;
        private double salary;
        private String position;
        private String email ="n/a";
        private int age=-1;


    public Person(String name, double salary, String position) {
        this.name = name;
        this.salary = salary;
        this.position = position;

    }

    public double getSalary() {
        return salary;
    }



    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
