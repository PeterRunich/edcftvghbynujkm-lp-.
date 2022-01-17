package app;

import javax.xml.namespace.QName;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Class parentClass = Dog.class;
        int counter = 0;

        while (parentClass != Object.class) {
            counter += 2;
            int finalCounter = counter;

            System.out.println(parentClass);
            System.out.println(Arrays.stream(parentClass.getConstructors()).map(constructor -> " ".repeat(finalCounter) + "- " + constructor).collect(Collectors.joining("\n")));
            System.out.println(Arrays.stream(parentClass.getFields()).map(field -> " ".repeat(finalCounter) + "+ " +field.getName()).collect(Collectors.joining("\n")));
            System.out.println(Arrays.stream(parentClass.getDeclaredMethods()).map(field -> " ".repeat(finalCounter) + "* " +field).collect(Collectors.joining("\n")));

            parentClass = parentClass.getSuperclass();
        }
    }
}

class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }
}

class Dog extends Animal {
    public int legs;
    public int eyes;

    public Dog(String name, int legs, int eyes) {
        super(name);
        this.legs = legs;
        this.eyes = eyes;
    }

    public String getName() {
        return name;
    }
}