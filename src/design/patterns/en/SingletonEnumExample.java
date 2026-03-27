package design.patterns.en;

import java.lang.reflect.Constructor;

public enum SingletonEnumExample {

    INSTANCE;

    public String sayHello() {
        return "Hello";
    }
}

class EnumSingletonMain {
    public static void main(String[] args) {
        SingletonEnumExample singletonEnumExample = SingletonEnumExample.INSTANCE;
        SingletonEnumExample singletonEnumExample1 = SingletonEnumExample.INSTANCE;
        System.out.println(singletonEnumExample.sayHello());
        System.out.println(singletonEnumExample.hashCode());
        System.out.println(singletonEnumExample1.hashCode());

        // Java language specification prohibits the reflective instantiation of Enums.
        // If you try to run newInstance() on an Enum constructor, the JVM throws an IllegalArgumentException
        try {
            //Get the constructor (Enums have a special constructor: String, int)
            Constructor<SingletonEnumExample> singletonEnumExampleConstructor = SingletonEnumExample.class.getDeclaredConstructor(String.class, int.class);
            singletonEnumExampleConstructor.setAccessible(true);

            // throws java.lang.IllegalArgumentException: Cannot reflectively create enum objects
            SingletonEnumExample singletonEnumExample2 = singletonEnumExampleConstructor.newInstance("INSTANCE", 0);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
