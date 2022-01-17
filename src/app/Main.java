package app;

import org.reflections.Reflections;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Reflections reflections = new Reflections("app");
        Class       parentClass = Animal.class;

        Set<Class> classes = reflections.getSubTypesOf(parentClass);

        classInfo(parentClass, 2);
        for (Class klass:classes) {
            classInfo(klass, 4);
        }
    }

    private static void classInfo(Class parentClass, int countSpaces) {
        System.out.println(" ".repeat(countSpaces - 2) + "-> " + parentClass);
        System.out.println(Arrays.stream(parentClass.getConstructors()).map(constructor -> " ".repeat(countSpaces) + "- " + constructor).collect(Collectors.joining("\n")));
        System.out.println(Arrays.stream(parentClass.getFields()).map(field -> " ".repeat(countSpaces) + "+ " +field.getName()).collect(Collectors.joining("\n")));
        System.out.println(Arrays.stream(parentClass.getDeclaredMethods()).map(field -> " ".repeat(countSpaces) + "* " +field.getName()).collect(Collectors.joining("\n")));
    }
}

class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public void speak() {}
}

class Cat extends Animal {
    public String catField;

    public Cat(String name) {
        super(name);
    }

    public void catMethod() {}
}

class Dog extends Animal {
    public String dogField;

    public Dog(String name) {
        super(name);
    }

    public void dogMethod() {}
}