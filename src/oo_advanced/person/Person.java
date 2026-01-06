package oo_advanced.person;
/*
Haz una clase llamada Persona que siga las siguientes condiciones:

Sus atributos son: nombre, edad, DNI, sexo (H hombre, M mujer), peso y altura.
No queremos que se accedan directamente a ellos.
Piensa que modificador de visibilidad es el más adecuado, también su tipo.
Si quieres añadir algún atributo puedes hacerlo.

Se implantarán varios constructores:

Un constructor con el nombre.
Un constructor con el nombre, edad y sexo.
Un constructor con todos los atributos como parámetro, salvo el DNI.
Los métodos que se implementarán son:

calcularIMC(): calculara si la persona está en su peso ideal (peso en kg/(altura^2 en m)),
 si esta fórmula devuelve un valor menor que 20, el método devuelve un -1, si devuelve un número entre 20
y 25 (incluidos), está en un peso normal, por tanto, devuelve un 0 y si devuelve un valor mayor que 25
significa que tiene sobrepeso, devuelve un 1. Te recomiendo que uses constantes para devolver
estos valores.
esMayorDeEdad(): indica si es mayor de edad, devuelve un booleano.
comprobarSexo(char sexo): comprueba que el sexo introducido es correcto.
Si no es correcto, será H. No sería visible al exterior.
Devolverá el carácter correspondiente al sexo.
toString(): devuelve toda la información del objeto.
generaDNI(): genera un número aleatorio de 8 cifras y con ese número, calcula su letra correspondiente. Este método será invocado cuando se construya el objeto. No será visible al exterior.
Para calcular el DNI se debe obtener el módulo 23 del número. Y una vez obtenido, se relaciona el resto con la letra correspondiente:

RESTO	0	1	2	3	4	5	6	7	8	9	10	11
LETRA	T	R	W	A	G	M	Y	F	P	D	X	B
RESTO	12	13	14	15	16	17	18	19	20	21	22
LETRA	N	J	Z	S	Q	V	H	L	C	K	E

Métodos set y get de cada atributo.
Crear el método equals y hashCode.

Ahora, crea una clase principal que haga lo siguiente:

Pide por teclado el nombre, la edad, sexo, peso y altura.
Crea 3 objetos de la clase anterior:
El primer objeto utilizará todas las variables.
El segundo objeto utilizará todas las variables menos el peso y la altura.
El último utilizará el constructor que solo dispone del nombre.
Para cada persona se deberá comprobar si está en su peso ideal, tiene sobrepeso o por debajo de su peso ideal con un mensaje.
También hay que indicar, para cada persona, si es mayor de edad.
Por último, se debe mostrar la información de cada objeto.
NOTA: Deberás utilizar los métodos que consideres oportunos para realizar todas las acciones indicadas.

2. Se debe crear una clase Profesor que hereda de Persona, y que a su vez pueda ser ProfesorInterino o ProfesorTitular.

La clase Profesor deberá disponer de métodos y atributos relacionados con el módulo profesional que imparte (un atributo por módulo). Por ejemplo, 4 atributos móduloN, siendo N un número del 1 al 4.
La clase ProfesorInterino deberá disponer de un método que devuelva la fecha de inicio de la interinidad.
La clase ProfesorTitular dispondrá de un método que devuelva la fecha del aprobado de la oposición.
 */

import java.util.Objects;
import java.util.Random;

public class Person {
    private String name;
    private int age;
    private String dni;
    private char gender;
    private double weight;
    private double height;

    public static final int UNDERWEIGHT = -1;
    public static final int NORMAL = 0;
    public static final int OVERWEIGHT = 1;

    public Person(String name) {
        this.name = name;
        this.dni = generateDNI();
        this.gender = validateGender('H');
    }

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = validateGender(gender);
        this.dni = generateDNI();
    }

    public Person(String name, int age, char gender, double weight, double height) {
        this.name = name;
        this.age = age;
        this.gender = validateGender(gender);
        this.weight = weight;
        this.height = height;
        this.dni = generateDNI();
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public int calculateBMI() {
        double bmi = weight / (height * height);
        if (bmi < 20)
            return UNDERWEIGHT;
        else if (bmi <= 25)
            return NORMAL;
        else
            return OVERWEIGHT;
    }

    private char validateGender(char gender) {
        return (gender == 'H' || gender == 'M') ? gender : 'H';
    }

    private String generateDNI() {
        Random rand = new Random();
        int number = rand.nextInt(100000000);
        String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
        char letter = letters.charAt(number % 23);
        return String.format("%08d%c", number, letter);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = validateGender(gender);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Person))
            return false;
        Person person = (Person) o;
        return age == person.age &&
                gender == person.gender &&
                Double.compare(weight, person.weight) == 0 &&
                Double.compare(height, person.height) == 0 &&
                Objects.equals(name, person.name) &&
                Objects.equals(dni, person.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, dni, gender, weight, height);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dni='" + dni + '\'' +
                ", gender=" + gender +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
