package p03_SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        List<Car> carList =  new ArrayList<>();
        int lines = Integer.parseInt(reader.readLine());
        for (int i = 0; i <lines ; i++) {
            String[] items = reader.readLine().split(" ");
            String model = items[0];
            double fuelAmount = Double.parseDouble(items[1]);
            double fuelCost =  Double.parseDouble(items[2]);
            Car car = new Car(model,fuelAmount,fuelCost);

           carList.add(car);

        }
        while (!"End".equals(line=reader.readLine())) {
            String[] tokens = line.split(" ");
            String command = tokens[0];
            String model = tokens[1];
            double distance = Double.parseDouble(tokens[2]);
            if (command.equals("Drive")) {
            for (Car car : carList) {
                if (car.getModel().equals(model)) {
                    car.drive(model, distance);
                }
            }
        }
    }
        for (Car car : carList) {
            System.out.println(car.toString());
        }
    }
}
