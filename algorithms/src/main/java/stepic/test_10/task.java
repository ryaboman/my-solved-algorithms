package stepic.test_10;

import java.io.*;

public class task {
    public static void main(String[] args) throws IOException {
        Animal[] animalM1 = { new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
                new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
                new Animal("Tentecles"), new Animal("Worm")};
        ByteArrayOutputStream bai = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bai);
        oos.writeInt(animalM1.length);
        for (int i = 0; i < animalM1.length; i++) {
            oos.writeObject(animalM1[i]);
        }
        oos.flush();
        oos.close();
        Animal[] animalM2 = deserializeAnimalArray(bai.toByteArray());
        for (int i = 0; i < animalM2.length; i++) {
            System.out.println(animalM2[i].getName());
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data){
        Animal[] animals;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))){
            int countObject = objectInputStream.readInt();
            animals = new Animal[countObject];
            for (int i = 0; i < countObject; i++) {
                animals[i] = (Animal) objectInputStream.readObject();;
            }
        }
        catch (Exception e) {
            throw new IllegalArgumentException();
        }


        return animals;
    }
}
