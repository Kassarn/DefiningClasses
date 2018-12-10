package p02_CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        CatFactory catFactory = new CatFactory();
        List<Cat> catList =  new ArrayList<>();
        String input = "";
        while (!"End".equals(input=reader.readLine())){
            String [] tokens =input.split(" ");
           Cat cat = catFactory.getCat(tokens);
           catList.add(cat);
        }
        String name = reader.readLine();
        for (Cat cat : catList) {
            if(cat.getName().equals(name)){
                System.out.println(cat.toString());
            }
        }
    }
}
