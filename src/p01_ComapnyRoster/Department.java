package p01_ComapnyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
   private String name;
   private List<Person> persons;

    public Department() {
        this.persons = new ArrayList<>();
    }

    public Department(String name) {
        this();
        this.name = name;
    }

    public void addPerson(Person e){
            this.persons.add(e);
    }

    public String getName() {
        return name;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public double getAverage(){
        double res =0.0;
        for (Person person : persons) {
           res+=  person.getSalary();

        }
        return res/this.persons.size();
    }
}
