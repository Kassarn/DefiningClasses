package p05_OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            String[] personTokens =  reader.readLine().split(" ");
            String name = personTokens[0];
            int age = Integer.parseInt(personTokens[1]);
            Person person = new Person(name,age);
            persons.add(person);
        }

        persons.stream()
                .filter(person -> person.getAge()>30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);

    }
}
