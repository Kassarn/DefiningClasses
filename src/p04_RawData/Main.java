package p04_RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Car>  cars = new LinkedList<>();


        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            String model = tokens[0];
            int engineSpeed= Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(engineSpeed,enginePower);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType= tokens[4];
            Cargo  cargo = new Cargo(cargoType,cargoWeight);
            List<Tire> tires =  new ArrayList<>();

            for (int j = 5; j <tokens.length-1 ; j+=2) {
                    double tierPreassure= Double.parseDouble(tokens[j]);
                    int  age = Integer.parseInt(tokens[j+1]);
                    Tire tire = new Tire(age,tierPreassure);
                    tires.add(tire);
            }
            Car car =  new Car(model,engine,cargo,tires);
            cars.add(car);
        }
        String command = reader.readLine();
        switch (command){
            case "fragile":
                cars.stream().filter(car -> car.getTires().stream()
                        .filter(tire -> tire.getPreassure()<1).collect(Collectors.toList()).size()>0)
                        .filter(car -> car.getCargo().getType().equals("fragile"))
                        .forEach(System.out::println);
                break;
            case "flamable":
                cars.stream()
                        .filter(car -> car.getCargo().getType().equals("flamable"))
                        .filter(car -> car.getEngine().getPower()>250).forEach(System.out::println);
                break;

        }
    }
}
