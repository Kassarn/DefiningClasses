package p02_CatLady;

public class CatFactory {
    public Cat getCat(String [] tokens) {
        String breed = tokens[0];
        String name = tokens[1];
        double specificChar = Double.parseDouble(tokens[2]);

        switch (breed) {
            case "Siamese":
                return new Siamese(breed,name, specificChar);
            case "Cymric":
                return new Cymric(breed,name, specificChar);
            case "StreetExtraordinaire":
                return new StreetExtraordinaire(breed,name, specificChar);
                default:
                    return null;
        }


    }
}
