package lambda;

/*
Crea una lista de objetos Mascota, cada uno con nombre, tipo (perro, gato, etc.), y edad.

Usa una expresión lambda para contar cuántas mascotas son perros.

Usa filter para obtener todas las mascotas de más de 10 años.

Ordena las mascotas de menor a mayor edad con sorted y una expresión lambda.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pet {
    private String name;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<Pet> petList = new ArrayList<>();

        petList.add(new Pet("perro", 5));
        petList.add(new Pet("gato", 7));
        petList.add(new Pet("perro", 11));
        petList.add(new Pet("gato", 3));
        petList.add(new Pet("pájaro", 1));

        long dogCount = petList.stream()
                .filter(p -> p.getName().equals("perro"))
                .count();
        System.out.println("Número de perros: " + dogCount);

        List<Pet> seniors = petList.stream()
                .filter(p -> p.getAge() > 10)
                .toList();
        seniors.forEach(System.out::println);

        petList.stream()
                .sorted(Comparator.comparingInt(Pet::getAge))
                .forEach(System.out::println);
    }
}
